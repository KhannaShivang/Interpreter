package com.interpreter.jail;
import java.util.List;
import java.util.Map;
class JailClass implements JailCallable{
    final String name;
    private final Map<String, JailFunction> methods;
    JailClass(String name, Map<String, JailFunction> methods) {
        this.name = name;
        this.methods = methods;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public Object call(Interpreter interpreter,
        List<Object> arguments) {
        JailInstance instance = new JailInstance(this);
        return instance;
    }
    @Override
    public int arity() {
        return 0;
    }
    JailFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }
        return null;
  }
}
