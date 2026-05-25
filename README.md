**Prior Authorization App**
* A simple Java application that shows how prior authorization logic can work in software. The app includes a small rules engine, a basic UI, and an audit log. It gives a clear view of how UM decisions can be structured, explained, and recorded.

**Key Features**

**Rules Engine**
* A small decision module that checks patient inputs against synthetic criteria and returns an approval, denial, or review flag.

**JavaFX UI**
* A lightweight interface for entering patient information and viewing the determination.

**Audit Logging**  
* Every decision is written to a text log. The log shows the inputs, the outcome, and the reason.

**Transparent Logic**
* All rules are visible in code. No black boxes. No hidden steps.

**Synthetic Data Only**
* No PHI. No proprietary guidelines. No real payer criteria.

**Project Structure**
Code

PriorAuthApp/
│
├── src/
│   ├── Patient.java
│   ├── PriorAuthChecker.java
│   ├── PriorAuthUI.java
│
├── audit_log.txt
├── .gitignore
└── README.md

**Decision Framework**
* A request receives a determination based on a few simple checks:

* Age

* Diagnosis

* Treatment type

* Basic clinical flags

* Each check contributes to the final outcome. The result is written to the audit log with a short explanation.

**Audit Trail**
* The log includes:

* Patient inputs

* Decision

* Reason

* Timestamp

* The goal is clarity. Anyone reading the log should understand what happened and why.

**Technology Stack**

* Java
* JavaFX
* Plain text logging

