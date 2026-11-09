package edu.course.lab04;

final class CollisionKey {
    private final String id;

    public CollisionKey(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CollisionKey that = (CollisionKey) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 777;
    }
}
