package WeekContest.num194;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetFolderNamesTest {
    @Test
    public void getFolderNames() throws Exception {
        GetFolderNames getFolderNames=new GetFolderNames();
        getFolderNames.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"});
    }

}