package de.cultuzz.roomrateinfofetcher.manager.bestday;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultagent.bestday.GatewayRequest;
import com.cultagent.bestday.Response;
import com.cultagent.bestday.RoomType;
import com.cultagent.mappings.CultuzzCommRS;
import com.cultagent.mappings.ExtraInfo;
import com.cultagent.mappings.Info;
import com.cultagent.mappings.RoomRate;
import com.cultagent.mappings.RoomRates;
import com.cultagent.mappings.Success;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;
import de.cultuzz.roomrateinfofetcher.exceptions.RoomRateFetcherInfoException;
import de.cultuzz.roomrateinfofetcher.jpamanager.cultagent4.ChannelXCommunicationXDetailsManager;
import de.cultuzz.roomrateinfofetcher.resclient.RestClient;

@Component
public class BestDayManagerImpl implements BestDayManager{
	
	@Autowired
	private RestClient restClient;
	
	@Autowired 
	private ChannelXCommunicationXDetailsManager channelXCommunicationXDetailsManager;
	
	public CultuzzCommRS fecthBestDayRoomRateInfo(CommunicationDTO communicationDTO) throws DatatypeConfigurationException {
		CommunicationDTO communicationDTO1 = channelXCommunicationXDetailsManager.findByCommunication(communicationDTO.getDistributorId());
		if(communicationDTO1!=null) {
			communicationDTO.setChanneKey(communicationDTO1.getChanneKey());
			communicationDTO.setGmUrl(communicationDTO1.getGmUrl());
		}
		GatewayRequest gatewayRequest = this.getBestRoomTypesAndRatePlansInfo(communicationDTO);
		Response response = restClient.postXmlToBestDay(gatewayRequest, communicationDTO.getGmUrl());
		return this.prepareCultuzzCommRS(response);
	}
	
	public CultuzzCommRS prepareCultuzzCommRS(Response response) throws DatatypeConfigurationException{
		
		com.cultagent.mappings.ObjectFactory cultuzzCommRSFact = new com.cultagent.mappings.ObjectFactory();
        CultuzzCommRS cult_com_rs = cultuzzCommRSFact.createCultuzzCommRS();
        cult_com_rs.setVersion(BigDecimal.valueOf(1.1));
        GregorianCalendar cal = new GregorianCalendar();
        XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        cult_com_rs.setTimeStamp(gc);
        cult_com_rs.setTarget("Production");
        cult_com_rs.setSequenceNumber(BigInteger.ONE);
        RoomRates roomRates = new RoomRates();
        
        if(response.getErrorDescription()!=null)
        	throw new RoomRateFetcherInfoException(response.getErrorDescription());
        
		for(Iterator<RoomType> it = response.getGatewayResult().getRoomType().iterator();it.hasNext();){
			RoomType roomType = it.next();
			if(roomType!=null){
				RoomRate roomRate = new RoomRate();
                com.cultagent.mappings.Room cs_room = new com.cultagent.mappings.Room();
                com.cultagent.mappings.Rate cs_rate = new com.cultagent.mappings.Rate(); 
                cs_room.setId(roomType.getCode());
                cs_room.setName(roomType.getName());
                
                cs_rate.setId(roomType.getContract());
                cs_rate.setName(roomType.getContractName());
                
                ExtraInfo ei=new ExtraInfo();
                Info curr=new Info();
                curr.setName("currency");
                curr.setValue(roomType.getCurrency());
                ei.getInfo().add(curr);
                
                Info meal=new Info();
                meal.setName("Meal");
                meal.setValue(roomType.getMeal());
                ei.getInfo().add(meal);
                
                Info mealPlan=new Info();
                mealPlan.setName("MealName");
                mealPlan.setValue(roomType.getMealName());
                ei.getInfo().add(mealPlan);
                
                Info commission=new Info();
                commission.setName("CommissionableRate");
                commission.setValue(roomType.getCommissionableRate());
                ei.getInfo().add(commission);
                
                Info capacity=new Info();
                capacity.setName("RoomCapacity");
                capacity.setValue(roomType.getRoomCapacity());
                ei.getInfo().add(capacity);
                
                Info children=new Info();
                children.setName("Children");
                children.setValue(roomType.getChildren());
                ei.getInfo().add(children);
                
                Info junior=new Info();
                junior.setName("Junior");
                junior.setValue(roomType.getJunior());
                ei.getInfo().add(junior);
                
                Info isBase=new Info();
                isBase.setName("IsBase");
                isBase.setValue(roomType.getIsBase());
                ei.getInfo().add(isBase);
                
                Info rateTyp=new Info();
                rateTyp.setName("RateType");
                rateTyp.setValue(roomType.getRateType());
                ei.getInfo().add(rateTyp);
                
                cs_room.setExtraInfo(ei);
                roomRate.setRoom(cs_room);
                roomRate.setRate(cs_rate);
                roomRates.getRoomRate().add(roomRate);
			}
		}
		 cult_com_rs.setRoomRates(roomRates);
         Success success = new Success();
         cult_com_rs.setSuccess(success);
		return cult_com_rs;
	}
	
	public GatewayRequest getBestRoomTypesAndRatePlansInfo(CommunicationDTO communicationDTO){
		GatewayRequest gatewayRequest = new GatewayRequest();
		gatewayRequest.setChannel(communicationDTO.getChanneKey());
		gatewayRequest.setUserName(communicationDTO.getUserName());
		gatewayRequest.setPassword(communicationDTO.getPassword());
		gatewayRequest.setPropertyCode(communicationDTO.getHotelKey());
		return gatewayRequest;
	}
	
	
}
