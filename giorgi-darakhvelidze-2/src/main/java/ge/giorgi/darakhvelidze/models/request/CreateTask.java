package ge.giorgi.darakhvelidze.models.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class CreateTask {

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 20)
    private String title;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String description;

    private Date startDate;

    private Date endDate;

}
