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
    public Object call(Interpreter interpreter,List<Object> arguments) {
        JailInstance instance = new JailInstance(this);
        JailFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }
    @Override
    public int arity() {
        JailFunction initializer = findMethod("init");
        if (initializer == null) return 0;
            return initializer.arity();
        }
    JailFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }
        return null;
  }
}
