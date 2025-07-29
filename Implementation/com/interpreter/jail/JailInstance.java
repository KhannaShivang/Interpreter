package com.interpreter.jail;
import java.util.HashMap;
import java.util.Map;
class JailInstance {
    private JailClass klass;
    private final Map<String, Object> fields = new HashMap<>();
    JailInstance(JailClass klass) {
        this.klass = klass;
    }
    @Override
    public String toString() {
        return klass.name + " instance";
    }
    Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }
        JailFunction method = klass.findMethod(name.lexeme);
        if (method != null) return method.bind(this);
        throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
    }
    void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }
}
