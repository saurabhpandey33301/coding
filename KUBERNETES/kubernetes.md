# ☸️ Kubernetes Cheat Sheet

> A complete Kubernetes reference for Software Engineers, DevOps Engineers, and SDE Interviews.

---

# 📖 What is Kubernetes?

**Kubernetes (K8s)** is an open-source **Container Orchestration Platform** used to deploy, manage, scale, and automate containerized applications.

Docker creates containers.

Kubernetes manages thousands of them.

---

# 🚀 Why Kubernetes?

Imagine you have **100 Docker containers** running.

Questions arise:

* What if one crashes?
* How do you scale to 500 containers?
* How do containers communicate?
* How do you update an application without downtime?
* How do you expose applications to the internet?

Kubernetes solves all these problems.

---

# 🏗 Kubernetes Architecture

```text
                    User
                      │
                kubectl CLI
                      │
──────────────────────┼──────────────────────
                Control Plane
──────────────────────┼──────────────────────
API Server
Scheduler
Controller Manager
etcd
──────────────────────┼──────────────────────
        Worker Nodes
──────────────────────┼──────────────────────
Node 1        Node 2        Node 3
 │              │              │
Pods          Pods          Pods
 │              │              │
Containers   Containers   Containers
```

---

# 📚 Important Terminology

| Resource   | Description                      |
| ---------- | -------------------------------- |
| Cluster    | Collection of nodes              |
| Node       | Physical or Virtual machine      |
| Pod        | Smallest deployable unit         |
| Container  | Application running inside a Pod |
| Deployment | Manages Pods                     |
| ReplicaSet | Maintains desired number of Pods |
| Service    | Exposes Pods                     |
| Namespace  | Logical separation               |
| ConfigMap  | Store configuration              |
| Secret     | Store passwords/API keys         |
| Volume     | Persistent storage               |
| Ingress    | HTTP/HTTPS routing               |

---

# 🔄 Kubernetes Workflow

```text
Application
      │
Docker Image
      │
Deployment.yaml
      │
kubectl apply
      │
Deployment
      │
ReplicaSet
      │
Pods
      │
Service
      │
Users
```

---

# 📦 Cluster Information

## View Cluster Information

```bash
kubectl cluster-info
```

---

## View Nodes

```bash
kubectl get nodes
```

Example

```text
NAME       STATUS   ROLES
master     Ready    control-plane
worker1    Ready    worker
worker2    Ready    worker
```

---

## Detailed Node Information

```bash
kubectl describe node node-name
```

---

# 📦 Pods

Pods are the **smallest deployable unit** in Kubernetes.

A Pod may contain:

* One container
* Multiple tightly coupled containers

---

## List Pods

```bash
kubectl get pods
```

---

## Wide Output

```bash
kubectl get pods -o wide
```

Shows

* IP
* Node
* Status
* Restarts

---

## Describe a Pod

```bash
kubectl describe pod pod-name
```

Useful for debugging:

* Events
* Restart count
* Image
* Environment variables
* Mounted volumes

---

## View Pod Logs

```bash
kubectl logs pod-name
```

Follow logs

```bash
kubectl logs -f pod-name
```

Previous logs after restart

```bash
kubectl logs --previous pod-name
```

---

## Execute Commands

```bash
kubectl exec -it pod-name -- bash
```

If Bash isn't available

```bash
kubectl exec -it pod-name -- sh
```

---

## Delete a Pod

```bash
kubectl delete pod pod-name
```

> If the Pod belongs to a Deployment, Kubernetes automatically creates a replacement Pod.

---

# 🚀 Deployments

Deployment manages Pods and ReplicaSets.

Benefits:

* Self-healing
* Scaling
* Rolling Updates
* Rollbacks

---

## Create Deployment

```bash
kubectl apply -f deployment.yaml
```

---

## List Deployments

```bash
kubectl get deployments
```

---

## Describe Deployment

```bash
kubectl describe deployment app
```

---

## Delete Deployment

```bash
kubectl delete deployment app
```

---

# 📈 Scaling

Increase replicas

```bash
kubectl scale deployment app --replicas=5
```

Decrease replicas

```bash
kubectl scale deployment app --replicas=2
```

Verify

```bash
kubectl get pods
```

---

# 🔄 Rolling Updates

Restart deployment

```bash
kubectl rollout restart deployment app
```

Check rollout status

```bash
kubectl rollout status deployment app
```

View rollout history

```bash
kubectl rollout history deployment app
```

Rollback

```bash
kubectl rollout undo deployment app
```

---

# 🌐 Services

Services expose Pods.

List services

```bash
kubectl get svc
```

Describe service

```bash
kubectl describe svc service-name
```

---

## Types of Services

| Type         | Purpose                |
| ------------ | ---------------------- |
| ClusterIP    | Internal communication |
| NodePort     | Expose on Node IP      |
| LoadBalancer | Cloud load balancer    |
| ExternalName | DNS alias              |

---

# 📄 Example Deployment YAML

```yaml
apiVersion: apps/v1

kind: Deployment

metadata:
  name: nginx-deployment

spec:
  replicas: 3

  selector:
    matchLabels:
      app: nginx

  template:
    metadata:
      labels:
        app: nginx

    spec:
      containers:
      - name: nginx
        image: nginx:latest

        ports:
        - containerPort: 80
```

Deploy

```bash
kubectl apply -f deployment.yaml
```

---

# 🌐 Example Service YAML

```yaml
apiVersion: v1

kind: Service

metadata:
  name: nginx-service

spec:

  selector:
    app: nginx

  ports:

  - port: 80

    targetPort: 80

  type: NodePort
```

---

# 🔐 Namespaces

List namespaces

```bash
kubectl get namespaces
```

Create

```bash
kubectl create namespace dev
```

Use namespace

```bash
kubectl get pods -n dev
```

---

# 💾 ConfigMaps

Create

```bash
kubectl create configmap app-config --from-literal=ENV=prod
```

List

```bash
kubectl get configmaps
```

---

# 🔒 Secrets

Create

```bash
kubectl create secret generic db-secret --from-literal=password=123456
```

View

```bash
kubectl get secrets
```

---

# 📊 Monitoring

Current resource usage

```bash
kubectl top nodes
```

```bash
kubectl top pods
```

---

# 🔍 Debugging Commands

```bash
kubectl describe pod pod-name

kubectl logs pod-name

kubectl exec -it pod-name -- bash

kubectl get events

kubectl get all

kubectl describe node
```

---

# 🧹 Cleanup

Delete Pod

```bash
kubectl delete pod pod-name
```

Delete Deployment

```bash
kubectl delete deployment app
```

Delete Service

```bash
kubectl delete svc app
```

Delete Namespace

```bash
kubectl delete namespace dev
```

---

# 🚀 Complete Kubernetes Lifecycle

```text
Write Application
        │
        ▼
Build Docker Image
        │
        ▼
Push to Docker Hub
        │
        ▼
Create Deployment.yaml
        │
        ▼
kubectl apply
        │
        ▼
Deployment
        │
        ▼
ReplicaSet
        │
        ▼
Pods
        │
        ▼
Service
        │
        ▼
Ingress
        │
        ▼
Users
```

---

# 📋 Most Used kubectl Commands

| Task               | Command                                     |
| ------------------ | ------------------------------------------- |
| Cluster Info       | `kubectl cluster-info`                      |
| Nodes              | `kubectl get nodes`                         |
| Pods               | `kubectl get pods`                          |
| Services           | `kubectl get svc`                           |
| Deployments        | `kubectl get deployments`                   |
| Describe Pod       | `kubectl describe pod <pod>`                |
| Pod Logs           | `kubectl logs <pod>`                        |
| Shell into Pod     | `kubectl exec -it <pod> -- bash`            |
| Apply YAML         | `kubectl apply -f deployment.yaml`          |
| Delete Pod         | `kubectl delete pod <pod>`                  |
| Delete Deployment  | `kubectl delete deployment <name>`          |
| Scale Deployment   | `kubectl scale deployment app --replicas=5` |
| Restart Deployment | `kubectl rollout restart deployment app`    |
| Rollback           | `kubectl rollout undo deployment app`       |

---

# 🎯 Frequently Asked Interview Questions

### What is Kubernetes?

A container orchestration platform used to automate deployment, scaling, networking, and management of containerized applications.

---

### What is a Pod?

The smallest deployable unit in Kubernetes. A Pod encapsulates one or more containers that share networking and storage resources.

---

### Difference between Pod and Container?

| Pod                             | Container                         |
| ------------------------------- | --------------------------------- |
| Kubernetes abstraction          | Application runtime instance      |
| Can contain multiple containers | Runs a single application/process |
| Shares network and storage      | Lives inside a Pod                |

---

### What is a Deployment?

A higher-level resource that manages ReplicaSets and Pods, enabling declarative updates, self-healing, scaling, and rollbacks.

---

### What is a ReplicaSet?

Ensures that the desired number of Pod replicas are always running.

---

### What is a Service?

Provides a stable network endpoint to access Pods, even as Pods are created or destroyed.

---

### Why are Pods ephemeral?

Pods are designed to be replaceable. If one fails, Kubernetes schedules a new Pod automatically instead of repairing the existing one.

---

### What is Ingress?

A Kubernetes resource that manages external HTTP/HTTPS access to Services, often providing routing, SSL termination, and load balancing.

---

### What is etcd?

A distributed key-value store that holds the entire state and configuration of the Kubernetes cluster.

---

### Difference between Docker and Kubernetes?

| Docker                      | Kubernetes                          |
| --------------------------- | ----------------------------------- |
| Creates and runs containers | Orchestrates and manages containers |
| Single-host focus           | Multi-node cluster management       |
| Packaging tool              | Container orchestration platform    |

---

# 💡 Best Practices

* Use **Deployments** instead of creating Pods directly.
* Define CPU and memory requests/limits.
* Use **Namespaces** to isolate environments (dev, staging, production).
* Store sensitive data in **Secrets**, not ConfigMaps.
* Use **ConfigMaps** for application configuration.
* Prefer **Rolling Updates** over deleting and recreating Pods.
* Add **Liveness** and **Readiness Probes** for production workloads.
* Monitor cluster health with metrics and logs.
* Keep manifests in version control (GitOps).
* Avoid using the `latest` image tag in production.

---

# 🚀 Happy Orchestrating!

> **Docker packages your application. Kubernetes keeps it running reliably at scale.** ☸️
