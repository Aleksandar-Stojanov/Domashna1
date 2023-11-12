import java.io.IOException;

public interface FilterData <T>{
    T execute(T input) throws IOException;
}