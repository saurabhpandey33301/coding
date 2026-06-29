# 🐳 Docker Cheat Sheet

A complete beginner-to-intermediate Docker reference for Software Engineers.

---

# 📖 What is Docker?

Docker is a **containerization platform** that packages an application along with all its dependencies into a **container**, ensuring it runs consistently across different environments.

Instead of saying:

> "It works on my machine."

Docker allows you to say:

> "It works everywhere."

---

# 🏗 Docker Architecture

```text
Developer
     │
     ▼
Dockerfile
     │
     ▼
Docker Image
     │
docker run
     ▼
Docker Container
```

---

# 📚 Important Terminology

| Term           | Description                      |
| -------------- | -------------------------------- |
| Image          | Blueprint of an application      |
| Container      | Running instance of an image     |
| Dockerfile     | Instructions to build an image   |
| Docker Hub     | Public image registry            |
| Volume         | Persistent storage               |
| Network        | Communication between containers |
| Docker Compose | Run multiple containers together |

---

# ⚙ Verify Docker Installation

Check Docker version.

```bash
docker --version
```

Example Output

```text
Docker version 28.x.x
```

Check Docker information.

```bash
docker info
```

---

# 📥 Download Images

Pull an image from Docker Hub.

```bash
docker pull ubuntu
```

Download a specific version.

```bash
docker pull ubuntu:22.04
```

---

# 📦 Docker Images

List downloaded images.

```bash
docker images
```

Example Output

```text
REPOSITORY     TAG       IMAGE ID
ubuntu         latest    35a888...
nginx          latest    a6bd71...
```

Remove an image.

```bash
docker rmi ubuntu
```

Remove unused images.

```bash
docker image prune
```

---

# 📦 Docker Containers

List running containers.

```bash
docker ps
```

List all containers.

```bash
docker ps -a
```

Example Output

```text
CONTAINER ID   IMAGE     STATUS
a12bc3         ubuntu    Up 5 minutes
```

---

# ▶ Run Containers

Run a container.

```bash
docker run ubuntu
```

Run interactively.

```bash
docker run -it ubuntu bash
```

Run in background.

```bash
docker run -d nginx
```

Run with a custom name.

```bash
docker run --name myubuntu ubuntu
```

Run and expose a port.

```bash
docker run -p 8080:80 nginx
```

Run with environment variables.

```bash
docker run -e ENV=production ubuntu
```

---

# 💻 Execute Commands Inside a Container

Open a Bash shell.

```bash
docker exec -it container_name bash
```

Run a single command.

```bash
docker exec container_name ls
```

---

# ⏹ Stop & Start Containers

Stop a running container.

```bash
docker stop container_name
```

Start a stopped container.

```bash
docker start container_name
```

Restart.

```bash
docker restart container_name
```

Pause.

```bash
docker pause container_name
```

Unpause.

```bash
docker unpause container_name
```

---

# 🗑 Remove Containers

Delete a stopped container.

```bash
docker rm container_name
```

Force delete.

```bash
docker rm -f container_name
```

Delete all stopped containers.

```bash
docker container prune
```

---

# 📜 View Logs

Show container logs.

```bash
docker logs container_name
```

Follow logs in real time.

```bash
docker logs -f container_name
```

Last 100 lines.

```bash
docker logs --tail 100 container_name
```

---

# 🏗 Build Docker Images

Build from Dockerfile.

```bash
docker build -t app .
```

Build with version.

```bash
docker build -t app:v1 .
```

---

# 📄 Sample Dockerfile

```dockerfile
FROM ubuntu:22.04

WORKDIR /app

COPY . .

RUN apt update

CMD ["bash"]
```

Build it.

```bash
docker build -t myapp .
```

Run it.

```bash
docker run myapp
```

---

# 💾 Docker Volumes

Create a volume.

```bash
docker volume create myvolume
```

List volumes.

```bash
docker volume ls
```

Use a volume.

```bash
docker run -v myvolume:/data ubuntu
```

Remove unused volumes.

```bash
docker volume prune
```

---

# 🌐 Docker Networking

List networks.

```bash
docker network ls
```

Create a network.

```bash
docker network create mynetwork
```

Run using a network.

```bash
docker run --network=mynetwork nginx
```

---

# 🐙 Docker Compose

Docker Compose allows multiple containers to run together.

Start all services.

```bash
docker-compose up
```

Run in background.

```bash
docker-compose up -d
```

Stop services.

```bash
docker-compose down
```

View logs.

```bash
docker-compose logs
```

Restart.

```bash
docker-compose restart
```

---

# 📄 Sample docker-compose.yml

```yaml
version: "3"

services:
  web:
    image: nginx
    ports:
      - "8080:80"

  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: password
```

Run

```bash
docker-compose up
```

---

# 🔍 Inspect Docker Objects

Inspect a container.

```bash
docker inspect container_name
```

Inspect an image.

```bash
docker inspect image_name
```

---

# 📊 Resource Usage

Live container statistics.

```bash
docker stats
```

---

# 🧹 Cleanup Commands

Remove dangling images.

```bash
docker image prune
```

Remove unused containers.

```bash
docker container prune
```

Remove unused volumes.

```bash
docker volume prune
```

Remove everything unused.

```bash
docker system prune
```

Aggressive cleanup.

```bash
docker system prune -a
```

---

# 🚀 Complete Workflow

```text
Dockerfile
      │
      ▼
docker build
      │
      ▼
Docker Image
      │
docker run
      ▼
Container
      │
docker exec
      ▼
Application Running
```

---

# ⚡ Most Used Docker Commands

| Task                 | Command                          |
| -------------------- | -------------------------------- |
| Docker Version       | `docker --version`               |
| Pull Image           | `docker pull ubuntu`             |
| List Images          | `docker images`                  |
| Run Container        | `docker run ubuntu`              |
| Interactive Shell    | `docker run -it ubuntu bash`     |
| Background Container | `docker run -d nginx`            |
| Running Containers   | `docker ps`                      |
| All Containers       | `docker ps -a`                   |
| Stop Container       | `docker stop container`          |
| Start Container      | `docker start container`         |
| Restart Container    | `docker restart container`       |
| Delete Container     | `docker rm container`            |
| Delete Image         | `docker rmi image`               |
| Build Image          | `docker build -t app .`          |
| Container Logs       | `docker logs container`          |
| Execute Command      | `docker exec -it container bash` |
| Docker Compose Up    | `docker-compose up`              |
| Docker Compose Down  | `docker-compose down`            |
| Cleanup              | `docker system prune`            |

---

# 💡 Docker Interview Questions

### What is the difference between an Image and a Container?

* **Image** → Read-only blueprint.
* **Container** → Running instance of an image.

---

### What is Dockerfile?

A text file containing instructions to build a Docker image.

---

### What is Docker Compose?

A tool to define and manage multi-container applications using a `docker-compose.yml` file.

---

### Why use Docker?

* Consistent environments
* Easy deployment
* Isolation
* Lightweight virtualization
* Faster CI/CD
* Better scalability

---

### What is the difference between `docker run` and `docker start`?

| `docker run`            | `docker start`               |
| ----------------------- | ---------------------------- |
| Creates a new container | Starts an existing container |
| Uses an image           | Uses an existing container   |
| First-time execution    | Restart after stopping       |

---

### What is a Volume?

A mechanism for storing persistent data outside the container lifecycle.

---

### What is Port Mapping?

```bash
docker run -p 8080:80 nginx
```

* **8080** → Host machine
* **80** → Container

---

# 🎯 Best Practices

* Use official base images.
* Keep images small.
* Use `.dockerignore`.
* Don't run containers as root.
* Tag image versions (`v1`, `v2`) instead of always using `latest`.
* Use Docker Compose for multi-service projects.
* Clean unused images and containers regularly.
* Persist important data using volumes.
* Pin dependency versions for reproducible builds.

---

# 🚀 Happy Containerizing!

> **Build once, run anywhere.** 🐳
