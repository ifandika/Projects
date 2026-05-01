// ------------------------------
// 1. Define the complete set of keys we want on UI
//    including key labels AND their matching keyboard event .key / .code values.
//    We need to map physical keyboard press to UI elements.
//    For simplicity, we support standard letters, digits, and essential modifiers.
//    The goal: each UI button gets a dataset.keyValue for matching.
// ------------------------------


const keyDefinitions = [
  // Row 1: Digits and symbols (we'll capture standard digit keys)
  { display: "` ~", matchKeys: ["`", "~"], codeMatch: "Backquote" },
  { display: "1 !", matchKeys: ["1", "!"], codeMatch: "Digit1" },
  { display: "2 @", matchKeys: ["2", "@"], codeMatch: "Digit2" },
  { display: "3 #", matchKeys: ["3", "#"], codeMatch: "Digit3" },
  { display: "4 $", matchKeys: ["4", "$"], codeMatch: "Digit4" },
  { display: "5 %", matchKeys: ["5", "%"], codeMatch: "Digit5" },
  { display: "6 ^", matchKeys: ["6", "^"], codeMatch: "Digit6" },
  { display: "7 &", matchKeys: ["7", "&"], codeMatch: "Digit7" },
  { display: "8 *", matchKeys: ["8", "*"], codeMatch: "Digit8" },
  { display: "9 (", matchKeys: ["9", "("], codeMatch: "Digit9" },
  { display: "0 )", matchKeys: ["0", ")"], codeMatch: "Digit0" },
  { display: "- _", matchKeys: ["-", "_"], codeMatch: "Minus" },
  { display: "= +", matchKeys: ["=", "+"], codeMatch: "Equal" },
  {
    display: "⌫",
    matchKeys: ["Backspace"],
    codeMatch: "Backspace",
    extraClass: "key-wide",
  },

  // Row 2: QWERTYUIOP
  { display: "q Q", matchKeys: ["q", "Q"], codeMatch: "KeyQ" },
  { display: "w W", matchKeys: ["w", "W"], codeMatch: "KeyW" },
  { display: "e E", matchKeys: ["e", "E"], codeMatch: "KeyE" },
  { display: "r R", matchKeys: ["r", "R"], codeMatch: "KeyR" },
  { display: "t T", matchKeys: ["t", "T"], codeMatch: "KeyT" },
  { display: "y Y", matchKeys: ["y", "Y"], codeMatch: "KeyY" },
  { display: "u U", matchKeys: ["u", "U"], codeMatch: "KeyU" },
  { display: "i I", matchKeys: ["i", "I"], codeMatch: "KeyI" },
  { display: "o O", matchKeys: ["o", "O"], codeMatch: "KeyO" },
  { display: "p P", matchKeys: ["p", "P"], codeMatch: "KeyP" },
  { display: "[ {", matchKeys: ["[", "{"], codeMatch: "BracketLeft" },
  { display: "] }", matchKeys: ["]", "}"], codeMatch: "BracketRight" },
  { display: "\\ |", matchKeys: ["\\", "|"], codeMatch: "Backslash" },

  // Row 3: A S D F G H J K L
  { display: "a A", matchKeys: ["a", "A"], codeMatch: "KeyA" },
  { display: "s S", matchKeys: ["s", "S"], codeMatch: "KeyS" },
  { display: "d D", matchKeys: ["d", "D"], codeMatch: "KeyD" },
  { display: "f F", matchKeys: ["f", "F"], codeMatch: "KeyF" },
  { display: "g G", matchKeys: ["g", "G"], codeMatch: "KeyG" },
  { display: "h H", matchKeys: ["h", "H"], codeMatch: "KeyH" },
  { display: "j J", matchKeys: ["j", "J"], codeMatch: "KeyJ" },
  { display: "k K", matchKeys: ["k", "K"], codeMatch: "KeyK" },
  { display: "l L", matchKeys: ["l", "L"], codeMatch: "KeyL" },
  { display: "; :", matchKeys: [";", ":"], codeMatch: "Semicolon" },
  { display: "' \"", matchKeys: ["'", '"'], codeMatch: "Quote" },
  {
    display: "↵",
    matchKeys: ["Enter"],
    codeMatch: "Enter",
    extraClass: "key-wide",
  },

  // Row 4: Z X C V B N M and modifiers
  { display: "z Z", matchKeys: ["z", "Z"], codeMatch: "KeyZ" },
  { display: "x X", matchKeys: ["x", "X"], codeMatch: "KeyX" },
  { display: "c C", matchKeys: ["c", "C"], codeMatch: "KeyC" },
  { display: "v V", matchKeys: ["v", "V"], codeMatch: "KeyV" },
  { display: "b B", matchKeys: ["b", "B"], codeMatch: "KeyB" },
  { display: "n N", matchKeys: ["n", "N"], codeMatch: "KeyN" },
  { display: "m M", matchKeys: ["m", "M"], codeMatch: "KeyM" },
  { display: ", <", matchKeys: [",", "<"], codeMatch: "Comma" },
  { display: ". >", matchKeys: [".", ">"], codeMatch: "Period" },
  { display: "/", matchKeys: ["/", "?"], codeMatch: "Slash" },
  {
    display: "⇧ Shift",
    matchKeys: ["Shift"],
    codeMatch: "ShiftLeft",
    extraClass: "key-wide",
  },

  // Row 5: special control keys + spacebar
  {
    display: "Ctrl",
    matchKeys: ["Control"],
    codeMatch: "ControlLeft",
    extraClass: "key-small",
  },
  {
    display: "Alt",
    matchKeys: ["Alt"],
    codeMatch: "AltLeft",
    extraClass: "key-small",
  },
  {
    display: "Space",
    matchKeys: [" "],
    codeMatch: "Space",
    extraClass: "key-space",
  },
  {
    display: "Tab",
    matchKeys: ["Tab"],
    codeMatch: "Tab",
    extraClass: "key-small",
  },
  {
    display: "Caps",
    matchKeys: ["CapsLock"],
    codeMatch: "CapsLock",
    extraClass: "key-small",
  },
];

const rowStructure = [
  // row 0 : numbers and backtick, minus, equals, backspace
  keyDefinitions.slice(0, 14),
  // row 1 : QWERTY row
  keyDefinitions.slice(14, 27),
  // row 2 : ASDF + enter
  keyDefinitions.slice(27, 39),
  // row 3 : ZXCV.. shift row
  keyDefinitions.slice(39, 50),
  // row 4 : modifiers row (Ctrl Alt Space Tab Caps)
  keyDefinitions.slice(50, 55),
];

const rowNumbersDiv = document.getElementById("row-numbers");
const rowQwertyDiv = document.getElementById("row-qwerty");
const rowAsdfDiv = document.getElementById("row-asdf");
const rowZxcvDiv = document.getElementById("row-zxcv");
const rowModifiersDiv = document.getElementById("row-modifiers");
const rowContainers = [
  rowNumbersDiv,
  rowQwertyDiv,
  rowAsdfDiv,
  rowZxcvDiv,
  rowModifiersDiv,
];

const keyElementMap = new Map();

function buildKeyboard() {
  for (let r = 0; r < rowStructure.length; r++) {
    const rowKeys = rowStructure[r];
    const container = rowContainers[r];
    if (!container) continue;
    container.innerHTML = "";
    rowKeys.forEach((keyDef) => {
      const keyDiv = document.createElement("div");
      keyDiv.className = "key";
      if (keyDef.extraClass) {
        keyDiv.classList.add(keyDef.extraClass);
      }
      keyDiv.textContent = keyDef.display;
      if (keyDef.codeMatch) {
        keyDiv.dataset.code = keyDef.codeMatch;
      }
      if (keyDef.matchKeys && keyDef.matchKeys.length) {
        keyDiv.dataset.primaryKey = keyDef.matchKeys[0];
      }
      keyDiv.addEventListener("click", (e) => {
        e.stopPropagation();
        applyOceanEffect(keyDiv);
        let simulatedKey = keyDef.display;
        if (keyDef.display === "Space") simulatedKey = " ";
        else if (keyDef.display === "⌫") simulatedKey = "Backspace";
        else if (keyDef.display === "↵") simulatedKey = "Enter";
        else if (keyDef.display === "⇧ Shift") simulatedKey = "Shift";
        else if (keyDef.display === "Ctrl") simulatedKey = "Control";
        else if (keyDef.display === "Alt") simulatedKey = "Alt";
        else if (keyDef.display === "Tab") simulatedKey = "Tab";
        else if (keyDef.display === "Caps") simulatedKey = "CapsLock";
        else {
          simulatedKey =
            keyDef.display.length === 1 ? keyDef.display : keyDef.display;
        }
        updateTextAreaFromKey(simulatedKey);
      });
      container.appendChild(keyDiv);

      if (keyDef.codeMatch) {
        keyElementMap.set(keyDef.codeMatch, keyDiv);
      }
      if (keyDef.matchKeys) {
        keyDef.matchKeys.forEach((match) => {
          if (!keyElementMap.has(match.toLowerCase())) {
            keyElementMap.set(match.toLowerCase(), keyDiv);
          }
          if (match === " ") keyElementMap.set(" ", keyDiv);
          if (match === "Backspace") keyElementMap.set("Backspace", keyDiv);
          if (match === "Enter") keyElementMap.set("Enter", keyDiv);
          if (match === "Shift") keyElementMap.set("Shift", keyDiv);
          if (match === "Control") keyElementMap.set("Control", keyDiv);
          if (match === "Alt") keyElementMap.set("Alt", keyDiv);
          if (match === "Tab") keyElementMap.set("Tab", keyDiv);
          if (match === "CapsLock") keyElementMap.set("CapsLock", keyDiv);
        });
      }
      if (keyDef.codeMatch === "ShiftLeft") {
        keyElementMap.set("ShiftRight", keyDiv);
        keyElementMap.set("Shift", keyDiv);
      }
      if (keyDef.codeMatch === "ControlLeft") {
        keyElementMap.set("ControlRight", keyDiv);
        keyElementMap.set("Control", keyDiv);
      }
      if (keyDef.codeMatch === "AltLeft") {
        keyElementMap.set("AltRight", keyDiv);
        keyElementMap.set("Alt", keyDiv);
      }
      if (keyDef.codeMatch === "Space") keyElementMap.set(" ", keyDiv);
      if (keyDef.codeMatch === "Enter") keyElementMap.set("Enter", keyDiv);
      if (keyDef.codeMatch === "Backspace")
        keyElementMap.set("Backspace", keyDiv);
      if (keyDef.codeMatch === "Tab") keyElementMap.set("Tab", keyDiv);
      if (keyDef.codeMatch === "CapsLock")
        keyElementMap.set("CapsLock", keyDiv);
    });
  }
}

let activeTimeout = null;
function applyOceanEffect(keyElement) {
  if (!keyElement) return;
  keyElement.classList.remove("ocean-press");
  void keyElement.offsetWidth;
  keyElement.classList.add("ocean-press");
}

function scheduleRemoveEffect(keyElement) {
  if (activeTimeout) clearTimeout(activeTimeout);

  // Change to white background
  // setTimeout(() => {
  //   if (keyElement) {
  //     keyElement.classList.remove("ocean-press");
  //   }
  // }, 140);
}

function updateTextAreaFromKey(pressedKeyValue) {
  const displayInput = document.getElementById("keyDisplay");
  if (!displayInput) return;
  let outputText = "";
  if (pressedKeyValue === "Backspace") {
    let current = displayInput.value;
    displayInput.value = current.slice(0, -1);
    return;
  } else if (pressedKeyValue === "Enter") {
    outputText = displayInput.value + "\n▶ ";
    displayInput.value = outputText;
    return;
  } else if (pressedKeyValue === "Tab") {
    outputText = displayInput.value + "    ";
    displayInput.value = outputText;
    return;
  } else if (pressedKeyValue === "Space" || pressedKeyValue === " ") {
    displayInput.value = displayInput.value + " ";
    return;
  } else if (pressedKeyValue && pressedKeyValue.length === 1 && /[\w\W]/) {
    displayInput.value = displayInput.value + pressedKeyValue;
    return;
  } else if (
    pressedKeyValue === "Shift" ||
    pressedKeyValue === "Control" ||
    pressedKeyValue === "Alt" ||
    pressedKeyValue === "CapsLock"
  ) {
    displayInput.value = displayInput.value + `⟨${pressedKeyValue}⟩`;
    return;
  }
  if (!pressedKeyValue || pressedKeyValue.length > 2) return;
  displayInput.value = displayInput.value + pressedKeyValue;
}

function handlePhysicalKeyPress(event) {
  if (
    event.key === " " ||
    event.key === "Space" ||
    event.key === "Backspace" ||
    event.key === "Tab"
  ) {
    event.preventDefault();
  }
  let pressedKey = event.key;
  const code = event.code;

  let targetKeyElement = null;
  if (pressedKey && pressedKey.length === 1) {
    const lowerKey = pressedKey.toLowerCase();
    if (keyElementMap.has(lowerKey))
      targetKeyElement = keyElementMap.get(lowerKey);
    else if (keyElementMap.has(pressedKey))
      targetKeyElement = keyElementMap.get(pressedKey);
  }
  if (!targetKeyElement && code && keyElementMap.has(code)) {
    targetKeyElement = keyElementMap.get(code);
  }
  if (!targetKeyElement && code && keyElementMap.has(code)) {
    targetKeyElement = keyElementMap.get(code);
  }
  if (!targetKeyElement && (pressedKey === " " || pressedKey === "Space")) {
    targetKeyElement = keyElementMap.get(" ") || keyElementMap.get("Space");
  }
  if (!targetKeyElement && pressedKey === "Backspace")
    targetKeyElement = keyElementMap.get("Backspace");
  if (!targetKeyElement && pressedKey === "Enter")
    targetKeyElement = keyElementMap.get("Enter");
  if (!targetKeyElement && pressedKey === "Shift")
    targetKeyElement = keyElementMap.get("Shift");
  if (!targetKeyElement && pressedKey === "Control")
    targetKeyElement = keyElementMap.get("Control");
  if (!targetKeyElement && pressedKey === "Alt")
    targetKeyElement = keyElementMap.get("Alt");
  if (!targetKeyElement && pressedKey === "Tab")
    targetKeyElement = keyElementMap.get("Tab");
  if (!targetKeyElement && pressedKey === "CapsLock")
    targetKeyElement = keyElementMap.get("CapsLock");

  if (targetKeyElement) {
    applyOceanEffect(targetKeyElement);
    // scheduleRemoveEffect(targetKeyElement);
  }

  let displayKey = pressedKey;
  if (pressedKey === " ") displayKey = "Space";
  if (pressedKey === "Control") displayKey = "Ctrl";
  if (pressedKey === "Alt") displayKey = "Alt";
  if (pressedKey === "Shift") displayKey = "Shift";
  if (pressedKey === "CapsLock") displayKey = "Caps";
  updateTextAreaFromKey(displayKey);
}

window.addEventListener("keydown", handlePhysicalKeyPress);

buildKeyboard();

document.body.addEventListener("click", () => {
  document.body.focus();
});
document.body.setAttribute("tabindex", "0");
document.body.style.outline = "none";
document.body.focus();

console.log(
  "Ocean Keyboard UI ready — press any physical key to see ocean blue effect + text area update",
);