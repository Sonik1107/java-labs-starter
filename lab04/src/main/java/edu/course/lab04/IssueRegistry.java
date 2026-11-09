package edu.course.lab04;

import java.util.HashMap;

public class IssueRegistry {
    private final HashMap<IssueId, ProjectTask> map = new HashMap<>();

    public void put(IssueId key, ProjectTask value) {
        map.put(key, value);
    }

    public ProjectTask get(IssueId key) {
        return map.get(key);
    }

    public ProjectTask remove(IssueId key) {
        return map.remove(key);
    }

    public boolean contains(IssueId key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }
}
