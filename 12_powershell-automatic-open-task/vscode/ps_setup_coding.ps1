# ===========================
# Set Up Coding
# ===========================
# 
# M. Ifandika
# https://ifandika.github.io/
# This file is for set up coding study, is like open browser, text editor, file like books, etc.
# So I crate a single file (powershell file) that contains many instructions to do this.

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "     Launching All Applications" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

Start-Sleep -Seconds 2
Write-Host "[INFO] Get ready for coding..." -ForegroundColor Green
Write-Host ""

# Open Browser
Start-Sleep -Seconds 1
Write-Host "[INFO] 1. Opening Browser Tabs..." -ForegroundColor Green

$firefox_path = "C:\Program Files\Mozilla Firefox\firefox.exe"
$urls = @(
  "https://translate.google.com",
  "https://calendar.google.com",
  "https://github.com/ifandika",
  "https://codeforces.com",
  "https://hackerrank.com",
  "https://ticktick.com",
  "https://chat.deepseek.com"
)

if (Test-Path $firefox_path) {
  Start-Process $firefox_path $urls[0]
  for($i = 1; $i -lt $urls.Count; $i++) {
    Start-Process $firefox_path $urls[$i]
  }
  Write-Host "[INFO] Firefox oponed with 7 tabs" -ForegroundColor Green
}
else {
  Write-Host "[INFO] Firefox not found" -ForegroundColor Red
}

# Open VSCode
Start-Sleep -Seconds 2
Write-Host ""
Write-Host "[INFO] 2. Opening Text Editor..." -ForegroundColor Green

$vscode_path = "C:\Users\Axioo\AppData\Local\Programs\Microsoft VS Code\Code.exe"

if (Test-Path $vscode_path) {
  Start-Process $vscode_path
  Write-Host "[INFO] Visual Studio Code oponed" -ForegroundColor Green
}
else {
  Write-Host "[INFO] Visual Studio Code not found" -ForegroundColor Red
}

# Open Terminal
Start-Sleep -Seconds 2
Write-Host ""
Write-Host "[INFO] 3. Opening Terminal..." -ForegroundColor Green

$wt_path = "$env:LOCALAPPDATA\Microsoft\WindowsApps\wt.exe"

if (Test-Path $wt_path) {
  Start-Process $wt_path
  Write-Host "[INFO] Windows Terminal oponed" -ForegroundColor Green
}
else {
  Write-Host "[INFO] Windows Terminal not found" -ForegroundColor Red
}

Start-Sleep -Seconds 2
Write-Host ""
Write-Host "[INFO] 4. Opening Windows File Explorer..." -ForegroundColor Green
Start-Process explorer
Write-Host "[INFO] Windows File Explorer opened" -ForegroundColor Green

Start-Sleep -Seconds 2
Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "     All applications launched!" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Read-Host "[INFO] Press Enter to exit"