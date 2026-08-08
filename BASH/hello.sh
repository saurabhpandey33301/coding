#!/bin/bash
# =============================================================
#  SHELL SCRIPTING - BEGINNER'S GUIDE
#  Run this script with: ./hello.sh arg1 arg2
#  Example             : ./hello.sh eren yeager
# =============================================================


# -------------------------------------------------------------
# SECTION 1: COMMENTS
# -------------------------------------------------------------
# Single-line comment starts with #

: '
This is a
multi-line comment.
Everything between the quotes is ignored.
'


# -------------------------------------------------------------
# SECTION 2: VARIABLES
# Rules:
#   - No spaces around the = sign
#   - Use $variable_name to access the value
# -------------------------------------------------------------
echo "===== SECTION 2: VARIABLES ====="

name="saurabh"                        # string variable
age=21                                 # number variable
pi=3.14                                # decimal variable

echo "Name : $name"
echo "Age  : $age"
echo "Pi   : $pi"


# -------------------------------------------------------------
# SECTION 3: TAKING USER INPUT
# -------------------------------------------------------------
echo ""
echo "===== SECTION 3: USER INPUT ====="

read -p "Enter your name: " user_name          # -p shows a prompt message
echo -n "Loading"                               # -n keeps cursor on same line
sleep 2 ; echo "..."                            # small delay for effect
echo "Hello, $user_name! Welcome to Bash."


# -------------------------------------------------------------
# SECTION 4: SPECIAL VARIABLES (Built-in)
#
#   $0  -> Script name
#   $1  -> First argument passed to script
#   $2  -> Second argument passed to script
#   $#  -> Total number of arguments
#   $@  -> All arguments (as separate words)
#   $?  -> Exit status of last command (0 = success)
#   $$  -> Process ID (PID) of current script
#   $USER -> Current logged-in user
#   $HOME -> Home directory of current user
#   $PWD  -> Current working directory
# -------------------------------------------------------------
echo ""
echo "===== SECTION 4: SPECIAL VARIABLES ====="

echo "Script name         : $0"
echo "First argument      : $1"
echo "Second argument     : $2"
echo "Total arguments     : $#"
echo "All arguments       : $@"

ls /nonexistent_path 2>/dev/null      # intentionally run a failing command
echo "Exit status (fail)  : $?"       # will print 1 (failure)

ls . > /dev/null                      # run a successful command
echo "Exit status (success): $?"      # will print 0 (success)

echo "Process ID (PID)    : $$"
echo "Current user        : $USER"
echo "Home directory      : $HOME"
echo "Current directory   : $PWD"


# -------------------------------------------------------------
# SECTION 5: IF / ELSE CONDITIONS
# NOTE: Spaces inside [ ] are required!
#   ==  string equality
#   !=  string not equal
#   -eq numeric equal | -ne not equal
#   -gt greater than  | -lt less than
# -------------------------------------------------------------
echo ""
echo "===== SECTION 5: IF / ELSE ====="

a="apple"
b="banana"

if [ "$a" == "$b" ]; then
    echo "$a is equal to $b"
else
    echo "$a is NOT equal to $b"
fi

num=10
if [ $num -gt 5 ]; then
    echo "$num is greater than 5"
elif [ $num -eq 5 ]; then
    echo "$num is equal to 5"
else
    echo "$num is less than 5"
fi


# -------------------------------------------------------------
# SECTION 6: LOOPS
# -------------------------------------------------------------
echo ""
echo "===== SECTION 6: LOOPS ====="

# --- For loop (range) ---
echo "For loop (1 to 5):"
for i in {1..5}; do
    echo "  i = $i"
done

# --- For loop (over a list) ---
echo "For loop (over a list):"
for fruit in apple banana cherry; do
    echo "  Fruit: $fruit"
done

# --- While loop ---
echo "While loop (count down from 3):"
count=3
while [ $count -gt 0 ]; do
    echo "  count = $count"
    count=$((count - 1))    # arithmetic using $(( ))
done

# --- Until loop (runs UNTIL condition is true) ---
echo "Until loop:"
n=1
until [ $n -gt 3 ]; do
    echo "  n = $n"
    n=$((n + 1))
done


# -------------------------------------------------------------
# SECTION 7: FUNCTIONS
# -------------------------------------------------------------
echo ""
echo "===== SECTION 7: FUNCTIONS ====="

greet() {
    local person=$1          # 'local' makes variable local to function
    echo "Hello, $person!"
}

add() {
    local result=$(( $1 + $2 ))
    echo "Sum of $1 + $2 = $result"
}

greet "eren"
greet "yeager"
add 7 3


# -------------------------------------------------------------
# SECTION 8: ARRAYS
# -------------------------------------------------------------
echo ""
echo "===== SECTION 8: ARRAYS ====="

fruits=("apple" "banana" "cherry" "date")

echo "First element  : ${fruits[0]}"
echo "Second element : ${fruits[1]}"
echo "All elements   : ${fruits[@]}"
echo "Array length   : ${#fruits[@]}"

echo "Loop through array:"
for fruit in "${fruits[@]}"; do
    echo "  - $fruit"
done


# -------------------------------------------------------------
# SECTION 9: STRING OPERATIONS
# -------------------------------------------------------------
echo ""
echo "===== SECTION 9: STRINGS ====="

str="Hello, Bash World!"

echo "Original string  : $str"
echo "Length           : ${#str}"
echo "Uppercase        : ${str^^}"
echo "Lowercase        : ${str,,}"
echo "Replace 'Bash'   : ${str/Bash/Shell}"
echo "Substring (7,4)  : ${str:7:4}"   # start at index 7, length 4


# -------------------------------------------------------------
# SECTION 10: ARITHMETIC
# Use $(( )) for integer math
# Use 'bc' for floating point
# -------------------------------------------------------------
echo ""
echo "===== SECTION 10: ARITHMETIC ====="

x=20
y=6

echo "x = $x, y = $y"
echo "Addition       : $((x + y))"
echo "Subtraction    : $((x - y))"
echo "Multiplication : $((x * y))"
echo "Division       : $((x / y))"    # integer division
echo "Modulo         : $((x % y))"
echo "Float division : $(echo "scale=2; $x / $y" | bc)"  # using bc for decimals


# -------------------------------------------------------------
# SECTION 11: EXIT STATUS
#
#   Every command/script returns an exit code when it finishes:
#     0   = success (no errors)
#     1   = general error / failure
#   1-255 = various error types (you define the meaning)
#
#   $? always holds the exit code of the LAST run command.
# -------------------------------------------------------------
echo ""
echo "===== SECTION 11: EXIT STATUS ====="

# Run a valid command and check its exit code
ls . > /dev/null
echo "Exit code after 'ls .'         : $?"   # prints 0 (success)

# Run an invalid command and check its exit code
ls /no_such_folder 2>/dev/null
echo "Exit code after bad 'ls'       : $?"   # prints 1 or 2 (failure)

# You can also check exit status inside an if block
if [ $? -ne 0 ]; then
    echo "Previous command failed!"
fi

# Using exit in a script:
#   exit 0  -> tell the caller "everything went fine"
#   exit 1  -> tell the caller "something went wrong"
#
# Example (uncomment to use):
# exit 0    # ends the script immediately with success status
# exit 1    # ends the script immediately with failure status


# -------------------------------------------------------------
# SECTION 12: CASE STATEMENT
# A cleaner alternative to many if/elif blocks.
# Works like switch/case in other languages.
# -------------------------------------------------------------
echo ""
echo "===== SECTION 12: CASE STATEMENT ====="

day="Monday"

case $day in
    Monday | Tuesday | Wednesday | Thursday | Friday)
        echo "$day is a weekday."
        ;;
    Saturday | Sunday)
        echo "$day is the weekend!"
        ;;
    *)
        echo "Unknown day: $day"
        ;;
esac

# Tip: each option ends with ;; and * is the default/fallback case


# -------------------------------------------------------------
# SECTION 13: FILE & DIRECTORY CHECKS
# Use these inside if statements to check the filesystem.
#
#   -e file   -> exists (file or dir)
#   -f file   -> is a regular file
#   -d path   -> is a directory
#   -r file   -> is readable
#   -w file   -> is writable
#   -x file   -> is executable
#   -s file   -> exists and is NOT empty
# -------------------------------------------------------------
echo ""
echo "===== SECTION 13: FILE & DIRECTORY CHECKS ====="

target_file="hello.sh"
target_dir="."

if [ -f "$target_file" ]; then
    echo "'$target_file' exists and is a file."
else
    echo "'$target_file' does NOT exist."
fi

if [ -d "$target_dir" ]; then
    echo "'$target_dir' is a directory."
fi

if [ -r "$target_file" ]; then
    echo "'$target_file' is readable."
fi

if [ -x "$target_file" ]; then
    echo "'$target_file' is executable."
else
    echo "'$target_file' is NOT executable. Run: chmod +x $target_file"
fi


# -------------------------------------------------------------
# SECTION 14: BREAK & CONTINUE (Loop Control)
#
#   break    -> exit the loop immediately
#   continue -> skip the rest of this iteration, go to next
# -------------------------------------------------------------
echo ""
echo "===== SECTION 14: BREAK & CONTINUE ====="

echo "break example (stop at 3):"
for i in {1..5}; do
    if [ $i -eq 3 ]; then
        break          # exits loop when i hits 3
    fi
    echo "  i = $i"
done

echo "continue example (skip 3):"
for i in {1..5}; do
    if [ $i -eq 3 ]; then
        continue       # skips printing when i is 3
    fi
    echo "  i = $i"
done


# -------------------------------------------------------------
# SECTION 15: COMMAND SUBSTITUTION & PIPING
#
#   $(command)  -> runs command and captures its output as a value
#   cmd1 | cmd2 -> sends output of cmd1 as input to cmd2
# -------------------------------------------------------------
echo ""
echo "===== SECTION 15: COMMAND SUBSTITUTION & PIPING ====="

# Command substitution: store command output in a variable
current_date=$(date)
echo "Current date/time : $current_date"

file_count=$(ls . | wc -l)
echo "Files in folder   : $file_count"

# Piping: chain commands
echo "Uppercase via pipe: $(echo "hello bash" | tr 'a-z' 'A-Z')"

# Nested substitution
user_home=$(eval echo ~$USER)
echo "Home dir          : $user_home"


# -------------------------------------------------------------
# SECTION 16: SCRIPT SAFETY & DEBUGGING OPTIONS
#
#   set -e  -> exit script immediately if any command fails
#   set -u  -> treat unset variables as errors
#   set -x  -> print each command before running it (debug mode)
#   set -o pipefail -> catch errors inside pipes too
#
# Best practice: add this near the top of serious scripts:
#   set -euo pipefail
# -------------------------------------------------------------
echo ""
echo "===== SECTION 16: DEBUGGING & SAFETY ====="

# Demo: set -x turns on trace mode for a block
echo "Enabling trace mode (set -x):"
set -x
greeting="hello"
echo "$greeting world"
set +x    # turn trace OFF again
echo "Trace mode disabled (set +x)."

# Note: 'set -e' is not demonstrated here because it would
# stop the whole script on any error. Add it at the very top
# of your own scripts for safer execution.


echo ""
echo "===== SCRIPT COMPLETE ====="