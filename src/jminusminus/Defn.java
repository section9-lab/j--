package jminusminus;

/**
 * The Defn type is used to implement definitions of things (local variables, formal arguments, types) that are
 * named in some context (aka scope).
 */
interface Defn {
    /**
     * The (local variable, formal parameter, or local or imported name) definition's type.
     *
     * @return the definition's type.
     */
    Type type();
}

/**
 * A definition of a type name. In the first instance, an identifier, but later resolved to a local name or an
 * imported name.
 */
class TypeNameDefn implements Defn {
    /**
     * The definition's type.
     */
    private final Type type;

    /**
     * Constructs a type name definition for a type.
     *
     * @param type the definition's type.
     */
    public TypeNameDefn(Type type) {
        this.type = type;
    }

    /**
     * Returns the type for this definition.
     *
     * @return the definition's type.
     */
    public Type type() {
        return type;
    }
}

/**
 * The definition for a local variable (including formal parameters). All local variables are allocated on the stack
 * at fixed offsets from the base of the stack frame and all have types. Some local variables have initializations.
 */
class LocalVariableDefn implements Defn {
    // The local variable's type.
    private final Type type;

    // The local variable's offset from the base of the current the stack frame.
    private final int offset;

    // Has this local variable been initialized?
    private boolean isInitialized;

    /**
     * Constructs a local variable definition for a local variable.
     *
     * @param type   the variable's type.
     * @param offset the variable's offset from the base of the current stack frame (allocated for each method
     *               invocation).
     */
    public LocalVariableDefn(Type type, int offset) {
        this.type = type;
        this.offset = offset;
    }

    /**
     * Returns the type for this variable.
     *
     * @return the type.
     */
    public Type type() {
        return type;
    }

    /**
     * Returns the offset of this variable on the stack frame.
     *
     * @return the offset.
     */
    public int offset() {
        return offset;
    }

    /**
     * Initializes this local variable.
     */
    public void initialize() {
        this.isInitialized = true;
    }

    /**
     * Returns true if this local variable has been initialized, and false otherwise.
     *
     * @return true if this local variable has been initialized, and false otherwise.
     */
    public boolean isInitialized() {
        return isInitialized;
    }
}
