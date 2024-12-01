package vendingmachine.model.dto;

import java.util.Map;

import vendingmachine.model.Change;

public class ChangeDTO {

    private final Map<Integer, Integer> changes;

    public ChangeDTO(Change change) {
        this.changes = change.getChanges();
    }

    public static ChangeDTO from(Change change) {
        return new ChangeDTO(change);
    }

    public Map<Integer, Integer> getChanges() {
        return changes;
    }
}
