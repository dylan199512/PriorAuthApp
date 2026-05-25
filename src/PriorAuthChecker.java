public class PriorAuthChecker {

    public String evaluate(int age, String diagnosis, String service, String payer) {
        StringBuilder audit = new StringBuilder();
        audit.append("--- Audit Log ---\n");

        // Rule 1: MRI + M54.5 requires conservative therapy
        if (service.equalsIgnoreCase("MRI") && diagnosis.equalsIgnoreCase("M54.5")) {
            audit.append("Rule 1: MRI + M54.5 requires conservative therapy → NOT MET\n\n");
            audit.append("Decision: PEND\n");
            audit.append("Reason: Conservative therapy not documented.\n");
            return audit.toString();
        } else {
            audit.append("Rule 1: Not applicable\n");
        }

        // Rule 2: Age < 18 → auto-pend
        if (age < 18) {
            audit.append("Rule 2: Patient under 18 → AUTO-PEND\n\n");
            audit.append("Decision: PEND\n");
            audit.append("Reason: Pediatric cases require manual review.\n");
            return audit.toString();
        } else {
            audit.append("Rule 2: Age requirement met\n");
        }

        // ⭐ Rule 3: Payer-specific rule
        if (payer.equalsIgnoreCase("CarePlus") && service.equalsIgnoreCase("CT Scan")) {
            audit.append("Rule 3: CarePlus requires PA for CT Scans → NOT MET\n\n");
            audit.append("Decision: PEND\n");
            audit.append("Reason: CarePlus requires prior authorization for CT Scans.\n");
            return audit.toString();
        } else {
            audit.append("Rule 3: Payer requirement met\n");
        }

        // Default approve
        audit.append("Rule 4: No restrictions met → APPROVE\n\n");
        audit.append("Decision: APPROVE\n");
        audit.append("Reason: No clinical or administrative flags detected.\n");

        return audit.toString();
    }
}
