# 🐚 Bash Scripting Guide

A beginner-friendly guide to Bash scripting for Linux and Software Engineers.

---

# 📜 What is Bash?

**Bash (Bourne Again SHell)** is a command-line interpreter used on Linux and macOS. It allows you to automate repetitive tasks by writing shell scripts.

A Bash script is simply a text file containing Linux commands.

---

# 🚀 Your First Bash Script

Create a file named `hello.sh`

```bash
#!/bin/bash

echo "Hello, World!"
```

Make it executable.

```bash
chmod +x hello.sh
```

Run it.

```bash
./hello.sh
```

---

# 📝 Comments

Single-line comment

```bash
# This is a comment
```

There is no official multi-line comment syntax, but this is commonly used:

```bash
: '
This is
a multiline
comment
'
```

---

# 📦 Variables

Declare a variable.

```bash
name="Saurabh"
```

Use a variable.

```bash
echo "$name"
```

Output

```text
Saurabh
```

> **Note:** Do not put spaces around `=`.

❌ Wrong

```bash
name = "Saurabh"
```

✅ Correct

```bash
name="Saurabh"
```

---

# 📥 User Input

Read input from the user.

```bash
read name
```

With a prompt.

```bash
read -p "Enter your name: " name
```

Example

```bash
#!/bin/bash

read -p "Enter your name: " name

echo "Welcome $name"
```

---

# 🖨 Printing Output

```bash
echo "Hello"
```

Print variables.

```bash
echo "$name"
```

Print without a newline.

```bash
echo -n "Loading..."
```

---

# 🔢 Command Line Arguments

Example script

```bash
#!/bin/bash

echo "First argument : $1"
echo "Second argument: $2"
echo "Total arguments: $#"
echo "All arguments  : $@"
echo "Script name    : $0"
```

Run

```bash
./script.sh hello world
```

Output

```text
First argument : hello
Second argument: world
Total arguments: 2
All arguments  : hello world
Script name    : ./script.sh
```

---

# 🔀 If Statement

```bash
if [ "$a" == "$b" ]
then
    echo "Equal"
fi
```

---

## If-Else

```bash
if [ "$age" -ge 18 ]
then
    echo "Adult"
else
    echo "Minor"
fi
```

---

## If-Else If

```bash
if [ "$marks" -ge 90 ]
then
    echo "Grade A"
elif [ "$marks" -ge 75 ]
then
    echo "Grade B"
else
    echo "Grade C"
fi
```

---

# 🔢 Comparison Operators

## Numeric

| Operator | Meaning               |
| -------- | --------------------- |
| `-eq`    | Equal                 |
| `-ne`    | Not Equal             |
| `-gt`    | Greater Than          |
| `-lt`    | Less Than             |
| `-ge`    | Greater Than or Equal |
| `-le`    | Less Than or Equal    |

Example

```bash
if [ "$a" -gt "$b" ]
then
    echo "a is larger"
fi
```

---

## String

| Operator    | Meaning      |
| ----------- | ------------ |
| `=` or `==` | Equal        |
| `!=`        | Not Equal    |
| `-z`        | Empty String |
| `-n`        | Not Empty    |

Example

```bash
if [ "$name" == "Saurabh" ]
then
    echo "Welcome!"
fi
```

---

# 🔁 For Loop

```bash
for i in {1..10}
do
    echo "$i"
done
```

Loop over files.

```bash
for file in *.cpp
do
    echo "$file"
done
```

Loop over an array.

```bash
names=("Alice" "Bob" "Charlie")

for name in "${names[@]}"
do
    echo "$name"
done
```

---

# 🔄 While Loop

```bash
count=1

while [ $count -le 5 ]
do
    echo "$count"
    ((count++))
done
```

Infinite loop

```bash
while true
do
    echo "Running..."
done
```

---

# 🛠 Functions

Define a function.

```bash
function greet() {
    echo "Hello!"
}
```

Call it.

```bash
greet
```

Function with arguments.

```bash
greet() {
    echo "Hello $1"
}

greet Saurabh
```

---

# 📂 Arrays

Create an array.

```bash
names=("Alice" "Bob" "Charlie")
```

Access an element.

```bash
echo "${names[0]}"
```

Print all elements.

```bash
echo "${names[@]}"
```

Length of array.

```bash
echo "${#names[@]}"
```

---

# 📁 File Testing

| Command | Meaning          |
| ------- | ---------------- |
| `-f`    | File exists      |
| `-d`    | Directory exists |
| `-r`    | Readable         |
| `-w`    | Writable         |
| `-x`    | Executable       |

Example

```bash
if [ -f "test.txt" ]
then
    echo "File exists"
fi
```

---

# ⚠ Exit Status

Successful execution

```bash
exit 0
```

Failure

```bash
exit 1
```

Check previous command status.

```bash
echo $?
```

---

# 📋 Useful Special Variables

| Variable | Meaning             |
| -------- | ------------------- |
| `$0`     | Script name         |
| `$1`     | First argument      |
| `$2`     | Second argument     |
| `$#`     | Number of arguments |
| `$@`     | All arguments       |
| `$?`     | Exit status         |
| `$$`     | Process ID          |
| `$USER`  | Current user        |
| `$HOME`  | Home directory      |
| `$PWD`   | Current directory   |

---

# 🚀 Complete Example

```bash
#!/bin/bash

echo "========== User Information =========="

read -p "Enter your name: " name

echo "Welcome, $name!"

for i in {1..5}
do
    echo "Iteration $i"
done

greet() {
    echo "Have a great day, $1!"
}

greet "$name"

echo "Script completed successfully."

exit 0
```

---

# 💡 Best Practices

* Always start scripts with `#!/bin/bash`.
* Quote variables using `"${variable}"`.
* Use meaningful variable names.
* Check exit status after important commands.
* Keep functions small and reusable.
* Comment complex logic.
* Test scripts before using them in production.

---

# ⌨ Useful Bash Shortcuts

| Shortcut   | Action                 |
| ---------- | ---------------------- |
| `Ctrl + C` | Stop script            |
| `Ctrl + D` | Exit shell             |
| `Ctrl + R` | Search command history |
| `Tab`      | Auto-complete          |
| `!!`       | Repeat last command    |
| `history`  | Show command history   |

---

# ⭐ Quick Reference

| Task         | Command                |
| ------------ | ---------------------- |
| Print Text   | `echo "Hello"`         |
| Variable     | `name="John"`          |
| Read Input   | `read name`            |
| If Statement | `if [ ]`               |
| For Loop     | `for i in {1..10}`     |
| While Loop   | `while true`           |
| Function     | `greet(){}`            |
| Arguments    | `$1`, `$2`, `$#`, `$@` |
| Exit Script  | `exit 0`               |

---

Happy Scripting! 🐚🚀
