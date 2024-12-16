package eredua.bean;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;

public class FacadeBean {
    private static BLFacade facadeInterface;

    private FacadeBean() {
        try {
            facadeInterface = new BLFacadeImplementation(new DataAccess());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BLFacade getBusinessLogic() {
        if (facadeInterface == null) {
            new FacadeBean();
        }
        return facadeInterface;
    }
}
