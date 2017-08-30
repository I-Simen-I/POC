package no.poc.domain.builder;

import java.lang.reflect.InvocationTargetException;

public class TypeBuilder<T> {
    private static final String ERROR_MESSAGE = "The typeclass %s needs a constructor with parameter typeId and name";
    private Class<T> typeClass;
    private String typeId;
    private String name;

    private TypeBuilder(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    public static <T> TypeBuilder<T> aBuilderOfType(Class<T> typeClass) {
        return new TypeBuilder<T>(typeClass);
    }

    public TypeBuilder<T> withTypeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

    public TypeBuilder<T> withName(String name) {
        this.name = name;
        return this;
    }

    public T build() {
        try {
            return typeClass.getConstructor(String.class, String.class).newInstance(typeId, name);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new UnsupportedOperationException(String.format(ERROR_MESSAGE, typeClass.getSimpleName()));
        }
    }
}
