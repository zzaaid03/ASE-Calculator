async function calculate() {
  const firstNumber = parseInt(
    document.getElementById("firstNumber").value,
    10,
  );
  const operator = document.getElementById("operator").value;
  const secondNumber = parseInt(
    document.getElementById("secondNumber").value,
    10,
  );
  const display = document.getElementById("display");
  const errorDiv = document.getElementById("error");

  errorDiv.textContent = "";

  if (isNaN(firstNumber) || isNaN(secondNumber)) {
    errorDiv.textContent = "Please enter valid numbers.";
    return;
  }

  try {
    const response = await fetch("/api/calculate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ firstNumber, operator, secondNumber }),
    });

    const data = await response.json();

    if (data.error) {
      errorDiv.textContent = data.error;
      display.textContent = "Error";
    } else {
      display.textContent = data.result;
      loadHistory();
    }
  } catch (error) {
    errorDiv.textContent = "Could not reach the server.";
  }
}

async function loadHistory() {
  try {
    const response = await fetch("/api/history");
    const history = await response.json();
    const list = document.getElementById("historyList");

    if (history.length === 0) {
      list.innerHTML = '<li class="empty">No calculations yet.</li>';
    } else {
      list.innerHTML = history
        .slice()
        .reverse()
        .map((entry) => `<li>${entry}</li>`)
        .join("");
    }
  } catch (error) {
    console.error("Failed to load history:", error);
  }
}

async function clearHistory() {
  try {
    await fetch("/api/history", { method: "DELETE" });
    document.getElementById("display").textContent = "0";
    loadHistory();
  } catch (error) {
    document.getElementById("error").textContent =
      "Could not reach the server.";
  }
}

// Allow pressing Enter to calculate
document.addEventListener("keydown", (event) => {
  if (event.key === "Enter") calculate();
});

// Load history on page load
loadHistory();
