package info.behzadian.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {

    /**
     * Auto generated ID of entity In MySQL and Hibernate 5, the GenerationType.AUTO
     * generator type will result in using the TABLE generator. This adds a
     * significant performance penalty. The TABLE generator type doesn’t scale well
     * and is much slower than the IDENTITY and SEQUENCE (not supported in MySQL)
     * generators types, even with a single database connection. Rely on IDENTITY or
     * on the native generator type. In PostgreSQL, we can use SEQUENCE generator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A transient object has a null ID, and after it is persisted and become
     * managed, it has a valid (non-null) ID. This means that the same object can
     * have different IDs in different state transitions; therefore a hashCode()
     * based on an ID (e.g., Objects.hash(getId())) will return two different values
     * (in other words, this object is not equal to itself across the state
     * transitions; it will not be found in the Set). Returning a constant from
     * hashCode() will solve the problem.
     *
     * @return hash code of Object
     */
    @Override
    public int hashCode() {
        return 157865;
    }

    /**
     * checks if another object is equal to this object
     *
     * @param obj another object
     * @return true if both objects are same instance or two loaded instance of a
     *         record (has same id)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) obj;

        return id != null && id.equals(that.getId());
    }
}
