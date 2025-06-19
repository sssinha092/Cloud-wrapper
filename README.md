# ☁️ VM Management API – Spring Boot

This is a lightweight Spring Boot application that powers an **agentic cloud VM management workflow**, abstracting cloud-specific SDK interactions behind a unified REST API (`/api/vm/execute`). The app is integrated with an agent (e.g., Dify) for intent recognition and automated execution of VM lifecycle actions such as `create`, `restart`, and `status`.

---

## 🚀 Features

* ✅ REST API to execute VM operations across **AWS**, **Azure**, and **GCP**
* ✅ Pluggable service architecture using `VMServiceFactory`
* ✅ Integrated with tools like **Dify** for LLM-driven workflows
* ✅ Easily extensible for future providers (e.g., Oracle, IBM Cloud)
* ✅ Optimized SDK usage to avoid tight coupling in application logic

---

## 📦 Endpoint Specification

### `POST /api/vm/execute`

Executes a cloud VM action.

#### Request Body:

```json
{
  "action": "create",             // required: "create" | "restart" | "status"
  "provider": "AZURE",            // required: "AZURE" | "AWS" | "GCP"
  "vmId": "vm-001",               // optional (required for restart/status)
  "region": "eastus",             // required
  "cpu": "4",                     // optional (required for create)
  "ram": "8GB"                    // optional (required for create)
}
```

#### Sample Curl:

```bash
curl -X POST http://localhost:8080/api/vm/execute \
  -H "Content-Type: application/json" \
  -d '{
    "action": "create",
    "provider": "AZURE",
    "region": "eastus",
    "cpu": "4",
    "ram": "8GB"
  }'
```

#### Response:

```json
{
  "status": "success",
  "message": "VM created successfully",
  "vmId": "vm-001"
}
```

---

## 🌐 Exposing the API Using Serveo (for Dev/Test)

To expose your local Spring Boot app via a public URL (e.g., for integration with Dify):

```bash
ssh -R 69b620b276b07fea61b8348f7ab4fc6e:80:localhost:8080 serveo.net
```

> 📝 Make sure your Spring Boot app is running on port `8080`.

After execution, your API will be publicly available at:

```
https://69b620b276b07fea61b8348f7ab4fc6e.serveo.net/api/vm/execute
```

---

## 🧩 Project Structure

```plaintext
.
├── src/
│   └── main/
│       ├── java/com/example/vm/
│       │   ├── controller/VMController.java
│       │   ├── service/VMServiceFactory.java
│       │   ├── service/aws/AwsVMService.java
│       │   ├── service/azure/AzureVMService.java
│       │   └── model/VMRequest.java
│       └── resources/
│           └── application.yml
└── README.md
```

---

## 🛠️ Prerequisites

* Java 17+
* Maven or Gradle
* SSH client (for Serveo tunnel)
* Cloud SDKs (configured where necessary in backend services)

---

## 🧪 Running the Application

```bash
./mvnw spring-boot:run
```

OR

```bash
./gradlew bootRun
```

---

## 🔒 Security (To Be Implemented)

* OAuth2 / JWT-based authentication
* Role-based access control (RBAC)
* Request/response logging & auditing

---

## 📌 Future Enhancements

* Add VM stop/delete support
* Auto-healing and monitoring integration
* Event-driven execution with Kafka/EventBridge
* Reinforcement learning-based scaling


