package edu.course.lab04;

import java.util.Objects;

public final class IssueId {
    private final String projectCode;
    private final int number;

    public IssueId(String projectCode, int number) {
        if (projectCode == null || projectCode.isBlank()) {
            throw new IllegalArgumentException("Код проекта не может быть null или пустым");
        }
        this.projectCode = projectCode;
        this.number = number;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IssueId issueId = (IssueId) obj;
        return number == issueId.number && projectCode.equals(issueId.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectCode, number);
    }
}
