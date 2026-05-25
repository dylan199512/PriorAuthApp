**Prior Authorization App**
<p>A simple Java application that shows how prior authorization logic can work in software. The app includes a small rules engine, a basic UI, and an audit log. It gives a clear view of how UM decisions can be structured, explained, and recorded.</p>

**Key Features**

**Rules Engine**
<p>A small decision module that checks patient inputs against synthetic criteria and returns an approval, denial, or review flag.</p>

**JavaFX UI**
A lightweight interface for entering patient information and viewing the determination.

**Audit Logging**  
<p>Every decision is written to a text log. The log shows the inputs, the outcome, and the reason.</p>

**Transparent Logic**
<p>All rules are visible in code. No black boxes. No hidden steps.</p>

**Synthetic Data Only**
<p>No PHI. No proprietary guidelines. No real payer criteria.</p>

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
<p>A request receives a determination based on a few simple checks:</p>

<p>Age</p>

<p>Diagnosis</p>

<p>Treatment type</p>

<p>Basic clinical flags</p>

<p>Each check contributes to the final outcome. The result is written to the audit log with a short explanation.</p>

**Audit Trail**
<p>The log includes:</p>

<p>Patient inputs</p>

<p>Decision</p>

<p>Reason</p>

<p>Timestamp</p>

<p>The goal is clarity. Anyone reading the log should understand what happened and why.</p>

**Technology Stack**

<p>Java</p>
<p>JavaFX</p>
<p></p>Plain text logging</p>

