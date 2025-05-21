## 📬 AWS Lambda SQS Email Notifier

This project is a **Spring Boot application** designed to run within an **AWS Lambda environment**, triggered by **SQS messages**, to send **booking confirmation emails** via **AWS SES**.

### ✨ Overview

* The application is deployed as a **container-based Lambda function**.
* It listens to an **Amazon SQS queue** for incoming JSON messages.
* When a message is received, Lambda:

  1. **Deserializes** the message into a Java object.
  2. **Fetches additional booking data** if necessary.
  3. Selects and fills an **email template**.
  4. Sends the final email using **Amazon Simple Email Service (SES)**.

### 💡 Technologies Used

* **Java 17**
* **Spring Boot**
* **AWS Lambda (Container Runtime)**
* **Amazon SQS**
* **Amazon SES**
* **Jib (for container image builds)**
* **Maven**

### 🚀 Use Case

Ideal for applications where booking or transactional data is queued and needs to trigger email workflows in a scalable, event-driven, serverless fashion.

---

Would you like me to add badges, example payloads, architecture diagrams, or deployment instructions as well?
