package two.test.dao;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tomlee
 * @program: lining
 * @Date: 2019/8/3 16:27
 * @Description:
 */

/*@Setter
@Getter
@Accessors(chain= true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
@Data
@Builder
public class User implements Serializable {

    private int age;
    private String name;
    private String position;
    private String hobby;
    private Date dateTime;
    private String remark1;
    private String remark2;
    private String remark3;

}
