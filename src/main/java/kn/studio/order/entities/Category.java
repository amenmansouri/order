package kn.studio.order.entities;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shortDescription;
    @Lob
    private String description;


    private int depth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static abstract class Builder<T extends Category, B extends Builder<T, B>> {
        protected T category;

        public Builder() {
            category = createCategory();
        }

        protected abstract T createCategory();

        public B id(Long id) {
            category.setId(id);
            return self();
        }

        public B name(String name) {
            category.setName(name);
            return self();
        }

        public B shortDescription(String shortDescription) {
            category.setShortDescription(shortDescription);
            return self();
        }

        public B description(String description) {
            category.setDescription(description);
            return self();
        }

        public B depth(int depth) {
            category.setDepth(depth);
            return self();
        }

        protected abstract B self();

        public T build() {
            return category;
        }
    }

}
