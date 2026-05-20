Project - 5

## Java Library Ebook Terminal
Terminal Based | No-Framework
By M. Ifandika

## Introduce
So in this project I am create a library ebook based on terminal, si is interactive program that accept input from user, user can add new data ebook and then can show all data ebook and then can search data ebook is data is exists will be print “found” if not will be print “not found”.

## Tech Stack
| Field | Tech Stack |
| -------- | -------- |
| Front-End / UI | - |
| Back-End / System | - Java |
| Database | - |
| Server | - |

## SDLC

## Project Structure
3_visual-keyboard-ui/
vscode/
-- P6_Ebook.java
-- P6_InformasiEbook.java

Explain:
- P6_Ebook.java : Contains main program, this file will be executed
- P6_InformasiEbook.java : Contains external program that store ebook data and then have 2 method operation for this program

## Implementations

## Documentations

## Usage
For example usage is like this.

```Bash
PS D:\Ifandika\Projects\5_java-library-ebook-terminal\vscode> javac .\P6_Ebook.java; java P6_Ebook
[ Ebook ]
[INFO] Masukan data Ebook:
Masukan data ID: 111
Masukan data Judul: How to Talk to Anyone
Masukan data Penerbit: HarperCollins
Masukan data Tahun Terbit: 1999
Masukan data Penulis: Leil Lowndes

[INFO] Scan data EBook:
Data ID                  : 111
Data Judul               : How to Talk to Anyone
Data Penerbit            : HarperCollins
Data Tahun Terbit        : 1999
Data Penulis             : Leil Lowndes

[INFO] Cari data EBook:
Masukan data Judul: How to Talk to Anyone
Masukan data Penerbit: HarperCollins

[INFO] Data Ebook dengan Judul : How to Talk to Anyone, Penerbit : HarperCollins ditemukan!
```

## Versions
#### v1 | code release 2.5.2026

- Contains feature to add, scan, and search data ebook
- 2 file programs