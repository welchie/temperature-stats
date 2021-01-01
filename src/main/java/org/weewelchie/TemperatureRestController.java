package org.weewelchie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.weewelchie.temperature.monitor.jpa.bean.TemperatureDataBean;

@Path("/temperature")
public class TemperatureRestController {

    private static Logger LOGGER = Logger.getLogger(TemperatureRestController.class.getName());

    @GET
    @Path("/all")   
    @Produces(MediaType.APPLICATION_JSON)
    public List<TemperatureDataBean> getAllData() {

        LOGGER.info("Getting all Data.");
        List<TemperatureDataBean> allData = new ArrayList<TemperatureDataBean>();
        List<TemperatureDataBean> findAllData = TemperatureDataBean.findAllData();
        for(TemperatureDataBean t:findAllData)
        {
            allData.add(t);
        }
        return allData;
    }

    @GET
    @Path("/all/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCount()
    {
        return TemperatureDataBean.findAllData().size();
    }
    
    @POST
    @Path("/add") 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public TemperatureDataBean addTemperatureData(TemperatureDataBean dataBean) {
        dataBean.timeStamp = LocalDateTime.now();
        LOGGER.info("DataBean: " + dataBean);
        dataBean.persist();
        return dataBean;
    }
}
