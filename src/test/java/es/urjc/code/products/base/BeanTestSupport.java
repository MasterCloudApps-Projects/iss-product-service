package es.urjc.code.products.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.ParameterizedType;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.randomizers.number.IntegerRandomizer;

public class BeanTestSupport<T> {

    public static final EnhancedRandom CUSTOM_RANDOM = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().seed(123L)
            .objectPoolSize(100).randomizationDepth(4).collectionSizeRange(1, 3)
            .randomize(Number.class, IntegerRandomizer.aNewIntegerRandomizer()).build();
    private final Class<T> clazz = getClazz();
    private final T entityA = createEntity();
    private final T entityB = createEntity();

    protected boolean checkDeepEquals = true;

    protected T getEntityA() {
        return entityA;
    }

    protected T getEntityB() {
        return entityB;
    }

    @SuppressWarnings("unchecked")
    private final Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private final T createEntity() {
        return CUSTOM_RANDOM.nextObject(clazz);
    }

    @Test
    public void havingEntitiesWithDifferentFieldsWhenEqualsThenShouldReturnFalse() {
        assertNotEquals(getEntityA(), getEntityB());
    }

    @Test
    public void havingSameEntitiesWhenEqualsThenShouldReturnTrue() {
        assertEquals(getEntityA(), getEntityA());
    }

    @Test
    public void havingEntitiesWithEqualsFieldsWhenEqualsThenShouldReturnTrue() {
        if (checkDeepEquals) {
            final Gson gson = new Gson();
            final T clonedEntityC = gson.fromJson(gson.toJson(getEntityA()), clazz);
            assertEquals(getEntityA(), clonedEntityC);
        }
    }

    @Test
    public void havingEntitiesWithDifferentFieldsWhenHashCodeThenShouldReturnDifferentValues() {
        assertNotEquals(getEntityA().hashCode(), getEntityB().hashCode());
    }

    @Test
    public void havingEntitiesWithEqualsFieldsWhenHashCodeThenShouldReturnEqualsValues() {
        assertEquals(getEntityA().hashCode(), getEntityA().hashCode());
    }

    @Test
    public void havingSameEntityWhenEqualsThenShouldReturnTrue() {
        final T entity = getEntityA();
        assertEquals(entity, entity);
    }

    @Test
    public void havingEntityAndObjectWhenEqualsThenShouldReturnFalse() {
        assertNotEquals(getEntityA(), new Object());
    }
}