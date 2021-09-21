package my.classes;

public interface Converter<F, T> {
    T convert(F from);
}
