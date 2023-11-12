import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PipeAndFilter <T>{
    private List<FilterData<T>> filters = new ArrayList<FilterData<T>>();

    public void addFilter(FilterData<T> filter){
        filters.add(filter);
    }

    public T runFilters(T input) throws IOException {
        for (FilterData<T> filter: filters) {
            input = filter.execute(input);

        }
        return input;
    }
}
