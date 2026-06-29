# 🐧 Linux Basics Cheat Sheet

A quick reference to the most commonly used Linux commands every Software Engineer should know.

---

# 📂 Navigation Commands

## Print Current Working Directory

Displays the full path of your current directory.

```bash
pwd
```

Example Output

```text
/home/saurabh/projects
```

---

## List Files and Directories

List files in the current directory.

```bash
ls
```

Show detailed information.

```bash
ls -l
```

Show hidden files as well.

```bash
ls -la
```

---

## Change Directory

Move into a directory.

```bash
cd folder_name
```

Go back one directory.

```bash
cd ..
```

Go to the home directory.

```bash
cd ~
```

Go to the previous directory.

```bash
cd -
```

---

# 📁 File & Directory Operations

## Create a Directory

```bash
mkdir folder_name
```

Create nested directories.

```bash
mkdir -p parent/child/grandchild
```

---

## Remove a File

```bash
rm file.txt
```

---

## Remove a Directory

Delete recursively.

```bash
rm -rf folder_name
```

> ⚠️ **Warning:** `rm -rf` permanently deletes files. There is no recycle bin.

---

## Copy Files

```bash
cp source.txt destination.txt
```

Copy directories recursively.

```bash
cp -r source_folder destination_folder
```

---

## Move or Rename Files

Move a file.

```bash
mv source destination
```

Rename a file.

```bash
mv old_name.txt new_name.txt
```

---

# 📄 View File Contents

## Display Entire File

```bash
cat file.txt
```

---

## View Large Files

```bash
less file.txt
```

Navigation inside `less`

| Key   | Action        |
| ----- | ------------- |
| ↑ / ↓ | Scroll        |
| Space | Next Page     |
| b     | Previous Page |
| q     | Quit          |

---

## View First Few Lines

```bash
head file.txt
```

Show first 20 lines.

```bash
head -20 file.txt
```

---

## View Last Few Lines

```bash
tail file.txt
```

Follow a log file in real time.

```bash
tail -f logfile.log
```

---

# 🔍 Search Commands

## Find Files

Find all C++ files.

```bash
find . -name "*.cpp"
```

Find all Python files.

```bash
find . -name "*.py"
```

Find directories.

```bash
find . -type d
```

---

## Search Text

Search inside a file.

```bash
grep "hello" file.txt
```

Recursive search.

```bash
grep -rn "main" .
```

Ignore case.

```bash
grep -i "error" logfile.log
```

---

# 🔐 Permissions

## Make a Script Executable

```bash
chmod +x script.sh
```

Example

```bash
./script.sh
```

---

## Change File Owner

```bash
sudo chown username file.txt
```

---

# 💾 Disk Usage

## Check Disk Space

```bash
df -h
```

Example Output

```text
Filesystem      Size Used Avail Use%
/dev/sda1       100G  65G   35G  65%
```

---

## Directory Size

```bash
du -sh *
```

---

# ⚙️ Process Management

## Show Running Processes

```bash
ps aux
```

---

## Interactive Process Monitor

```bash
top
```

Improved version (if installed)

```bash
htop
```

---

## Kill a Process

Normal termination.

```bash
kill PID
```

Force termination.

```bash
kill -9 PID
```

---

# 📜 Command History

Show previous commands.

```bash
history
```

Execute a previous command.

```bash
!100
```

Repeat the last command.

```bash
!!
```

---

# 🧹 Clear Terminal

```bash
clear
```

Keyboard Shortcut

```text
Ctrl + L
```

---

# 🚀 Most Frequently Used Commands

| Task              | Command                 |
| ----------------- | ----------------------- |
| Current Directory | `pwd`                   |
| List Files        | `ls -la`                |
| Change Directory  | `cd folder`             |
| Create Folder     | `mkdir folder`          |
| Delete File       | `rm file`               |
| Delete Folder     | `rm -rf folder`         |
| Copy File         | `cp source destination` |
| Move File         | `mv source destination` |
| View File         | `cat file`              |
| Large File Viewer | `less file`             |
| First Lines       | `head file`             |
| Last Lines        | `tail file`             |
| Live Log          | `tail -f logfile`       |
| Find Files        | `find . -name "*.cpp"`  |
| Search Text       | `grep -rn "text" .`     |
| Change Permission | `chmod +x script.sh`    |
| Disk Usage        | `df -h`                 |
| Folder Size       | `du -sh *`              |
| Running Processes | `ps aux`                |
| Process Monitor   | `top` / `htop`          |
| Kill Process      | `kill PID`              |
| Command History   | `history`               |
| Clear Terminal    | `clear`                 |

---

# 💡 Pro Tips

* Use **Tab** for auto-completion.
* Use **↑ / ↓** to browse previous commands.
* Press **Ctrl + C** to stop a running process.
* Press **Ctrl + D** to exit the terminal.
* Press **Ctrl + R** to search command history.
* Use `history | grep keyword` to find previous commands quickly.
* Prefer `rm -i` if you want confirmation before deleting files.
* Avoid running `rm -rf /` or deleting system directories as `root`.

---

# 📚 Common Linux Shortcuts

| Shortcut    | Description                    |
| ----------- | ------------------------------ |
| `Ctrl + C`  | Stop current command           |
| `Ctrl + Z`  | Suspend current process        |
| `Ctrl + D`  | Exit terminal                  |
| `Ctrl + L`  | Clear terminal                 |
| `Ctrl + R`  | Search command history         |
| `Tab`       | Auto-complete                  |
| `!!`        | Repeat last command            |
| `!<number>` | Execute a command from history |

---

# 🎯 Daily Linux Workflow

```bash
pwd

ls -la

cd project

git status

find . -name "*.cpp"

grep -rn "TODO" .

chmod +x build.sh

./build.sh

tail -f logs/app.log
```

---

# ⭐ Best Practices

* Keep files organized using directories.
* Use meaningful file names.
* Be cautious with `rm -rf`.
* Learn keyboard shortcuts—they save a lot of time.
* Use `grep`, `find`, and `history` regularly.
* Monitor system resources using `top` or `htop`.

---

Happy Learning! 🐧🚀
