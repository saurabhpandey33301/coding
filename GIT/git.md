# 🚀 Git Cheat Sheet

A quick reference guide for the Git commands you'll use daily as a Software Engineer.

---

# 📂 Repository Information

## Check repository status
```bash
git status
```

## View commit history
```bash
git log
```

## Compact commit history
```bash
git log --oneline
```

## Commit history with graph
```bash
git log --oneline --graph --decorate --all
```

## View configured remotes
```bash
git remote -v
```

## Show current branch
```bash
git branch
```

## Show all branches (Local + Remote)
```bash
git branch -a
```

## Show only remote branches
```bash
git branch -r
```

---

# 📥 Clone Repository

## Clone a repository

```bash
git clone <repository_url>
```

Example:

```bash
git clone https://github.com/user/project.git
```

---

# 🌿 Branch Management

## Create a new branch

```bash
git branch <branch_name>
```

## Switch to an existing branch

```bash
git checkout <branch_name>
```

## Create and switch to a new branch

```bash
git checkout -b <branch_name>
```

### Modern Git (Git 2.23+)

Switch branch

```bash
git switch <branch_name>
```

Create and switch

```bash
git switch -c <branch_name>
```

---

# 📦 Staging Changes

## Stage all modified files

```bash
git add .
```

## Stage a specific file

```bash
git add <file_name>
```

## Stage everything

```bash
git add -A
```

---

# ✅ Commit Changes

## Create a commit

```bash
git commit -m "Commit message"
```

## Edit previous commit message

```bash
git commit --amend -m "New commit message"
```

---

# ☁️ Push Changes

## Push current branch

```bash
git push origin <branch_name>
```

## First push (Set upstream)

```bash
git push -u origin <branch_name>
```

---

# 📥 Pull Changes

## Fetch + Merge

```bash
git pull origin <branch_name>
```

## Fetch only

```bash
git fetch
```

---

# 🔀 Merge Branches

Merge another branch into your current branch.

```bash
git merge <branch_name>
```

---

# 🔍 View Differences

## Show unstaged changes

```bash
git diff
```

## Show staged changes

```bash
git diff --cached
```

## Compare two branches

```bash
git diff main feature
```

---

# ↩️ Undo Changes

## Restore a file

```bash
git restore <file_name>
```

## Unstage a file

```bash
git restore --staged <file_name>
```

## Remove last commit (Keep changes)

```bash
git reset --soft HEAD~1
```

## Remove last commit (Delete changes)

```bash
git reset --hard HEAD~1
```

---

# 📦 Git Stash

## Save current work

```bash
git stash
```

## View stash list

```bash
git stash list
```

## Restore latest stash

```bash
git stash pop
```

---

# 🗑 Delete Branches

## Delete local branch

```bash
git branch -d <branch_name>
```

## Force delete local branch

```bash
git branch -D <branch_name>
```

## Delete remote branch

```bash
git push origin --delete <branch_name>
```

---

# 🏷 Tags

## List tags

```bash
git tag
```

## Create tag

```bash
git tag v1.0.0
```

## Push all tags

```bash
git push origin --tags
```

---

# 🚫 Ignore Files

Use a `.gitignore` file.

Example:

```gitignore
node_modules/
*.exe
*.log
.env
.vscode/
build/
dist/
```

---

# ⚙️ Git Configuration

## Show username

```bash
git config --global user.name
```

## Show email

```bash
git config --global user.email
```

## Set username

```bash
git config --global user.name "Your Name"
```

## Set email

```bash
git config --global user.email "you@example.com"
```

---

# 🔧 Useful Commands

## Files changed in last commit

```bash
git show --name-only
```

## Repository information

```bash
git remote show origin
```

## Current branch

```bash
git branch --show-current
```

## Who changed each line

```bash
git blame <file_name>
```

## Search commit messages

```bash
git log --grep="bug"
```

---

# 📅 Daily Workflow

```bash
git status

git pull origin main

git add .

git commit -m "Describe your changes"

git push origin main
```

---

# ❌ If Push Is Rejected

```bash
git pull origin main

# Resolve merge conflicts

git add .

git commit -m "Resolve merge conflicts"

git push origin main
```

---

# 🔄 Before Switching Branches

Commit your work

```bash
git status

git add .

git commit -m "Work in progress"
```

OR temporarily save it

```bash
git stash
```

---

# 🚑 Emergency Recovery

## View HEAD history

```bash
git reflog
```

## Recover deleted commit

```bash
git reset --hard <commit_hash>
```

---

# 📚 Most Common Git Commands

| Task | Command |
|------|---------|
| Check Status | `git status` |
| Pull Latest Changes | `git pull` |
| Add All Files | `git add .` |
| Commit | `git commit -m "message"` |
| Push Changes | `git push` |
| Create Branch | `git checkout -b feature` |
| Switch Branch | `git switch feature` |
| Fetch Changes | `git fetch` |
| Merge Branch | `git merge feature` |
| Stash Changes | `git stash` |
| View History | `git log --oneline` |
| Undo Last Commit | `git reset --soft HEAD~1` |

---

# 💡 Git Workflow Diagram

```text
Working Directory
        │
        ▼
 git add .
        │
        ▼
 Staging Area
        │
        ▼
git commit -m "message"
        │
        ▼
 Local Repository
        │
        ▼
git push origin branch
        │
        ▼
Remote Repository (GitHub)
```

---

# 🎯 Golden Rule

Before pushing code, always run:

```bash
git status
git pull
git add .
git commit -m "Meaningful commit message"
git push
```

---

# ⭐ Pro Tips

- Commit small, logical changes.
- Write meaningful commit messages.
- Pull before pushing.
- Never commit `.env` files.
- Use branches for every feature or bug fix.
- Use `git stash` before switching branches if you have unfinished work.
- Learn `git reflog`—it can save you from almost any Git mistake.

---

Happy Coding! 🚀