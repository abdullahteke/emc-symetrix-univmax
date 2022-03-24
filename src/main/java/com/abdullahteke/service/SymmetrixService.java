package com.abdullahteke.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.abdullahteke.model.Response;
import com.abdullahteke.model.Result;
import com.abdullahteke.model.ResultList;
import com.abdullahteke.model.Symmetrix;
import com.abdullahteke.model.SymmetrixMetric;
import com.abdullahteke.model.SymmetrixMetrics;
import com.abdullahteke.model.Unimax;
import com.abdullahteke.model.array.ArrayMetric;
import com.abdullahteke.model.array.ArrayMetricRequest;
import com.abdullahteke.model.srp.Srp;
import com.abdullahteke.model.srp.SrpInfo;
import com.abdullahteke.model.srp.SrpMetric;
import com.abdullahteke.model.srp.SrpMetricRequest;
import com.abdullahteke.model.thinpool.ThinPool;
import com.abdullahteke.model.thinpool.ThinPoolInfo;
import com.abdullahteke.model.thinpool.ThinPoolMetric;
import com.abdullahteke.model.thinpool.ThinPoolMetricRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ch.qos.logback.classic.Logger;

@Service
public class SymmetrixService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${emc.url}")
	private String restUrl;

	@Value("${emc.resource.system.symmetrix}")
	private String systemSymmetrix;

	@Value("${emc.resource.performance.srp.keys}")
	private String srpKeys;

	@Value("${emc.resource.performance.srp.metrics}")
	private String srpMetrics;

	@Value("${emc.resource.performance.array.metrics}")
	private String arrayMetrics;

	@Value("${emc.resource.performance.thinpool.keys}")
	private String thinPoolKeys;

	@Value("${emc.resource.performance.thinpool.metrics}")
	private String thinPoolMetrics;

	@Value("${xml.file.name}")
	private String xmlFileName;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(SymmetrixService.class);

	public List<String> getSymetrixList() {
		try {
			Unimax unimax = restTemplate.getForObject(restUrl + systemSymmetrix, Unimax.class);
			logger.info("SymmetrixList:" + objectMapper.writeValueAsString(unimax));
			List<String> symetrixList = unimax.getSymmetrixId();
			return symetrixList;

		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public List<ThinPool> getPoolListForSymmetrix(Symmetrix symmetrix) {
		try {
			if (symmetrix != null) {
				HttpEntity<Symmetrix> request = new HttpEntity<Symmetrix>(symmetrix);
				logger.info("poolListRequestBody:" + objectMapper.writeValueAsString(request.getBody()));
				ThinPoolInfo poolInfo = restTemplate.postForObject(restUrl + thinPoolKeys, request, ThinPoolInfo.class);
				logger.info("Pool list:" + poolInfo.toString());
				return poolInfo.getPoolInfo();
			}
		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage());
			ThinPool thinPool= new ThinPool();
			thinPool.setPoolId("NaN");
			thinPool.setLastAvailableDate(-1L);
			thinPool.setLastAvailableDate(-1L);
			
			List<ThinPool> retVal= new ArrayList<ThinPool>();
			
			retVal.add(thinPool);
			return retVal;
			
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	public List<Srp> getSrpListForSymmetrix(Symmetrix symmetrix) {
		try {
			if (symmetrix != null) {
				logger.info("Get Srp List for symmetrix:" + symmetrix.getSymmetrixId());
				HttpEntity<Symmetrix> request = new HttpEntity<Symmetrix>(symmetrix);
				logger.info("srpListRequestBody:" + objectMapper.writeValueAsString(request.getBody()));
				SrpInfo srpInfo = restTemplate.postForObject(restUrl + srpKeys, request, SrpInfo.class);
				logger.info("srpListResponse:" + srpInfo.toString());
				return srpInfo.getSrpInfo();
			}

		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage());
			Srp srp= new Srp();
			srp.setSrpId("NaN");
			srp.setLastAvailableDate(-1L);
			srp.setLastAvailableDate(-1L);
			
			List<Srp> retVal= new ArrayList<Srp>();
			
			retVal.add(srp);
			return retVal;
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return null;

	}

	public Response getArrayMetrics(Symmetrix symmetrix) {

		if (symmetrix != null) {

			ArrayMetricRequest request = new ArrayMetricRequest();
			DateTime dt = new DateTime();

			List<String> metricList = new ArrayList<String>();
			metricList.add("OverallHealthScore");
			metricList.add("HardwareHealthScore");
			metricList.add("SoftwareHealthScore");
			metricList.add("CriticalAlertCount");
			metricList.add("UsableCapacityTB");
			metricList.add("SubscribedCapacityTB");
			metricList.add("AllocatedCapacityTB");

			request.setSymmetrixId(symmetrix.getSymmetrixId());
			request.setDataFormat("Average");
			request.setEndDate(dt.toDate().getTime());
			request.setStartDate(dt.minusMinutes(5).toDate().getTime());
			request.setMetrics(metricList);

			try {
				HttpEntity<ArrayMetricRequest> httpEntityRequest = new HttpEntity<ArrayMetricRequest>(request);
				logger.info("ArrayMetricsRequestBody:" + objectMapper.writeValueAsString(httpEntityRequest.getBody()));
				Response retVal = restTemplate.postForObject(restUrl + arrayMetrics, httpEntityRequest, Response.class);
				logger.info("ArrayMetricsResponse:" + objectMapper.writeValueAsString(retVal));

				return retVal;
			} catch (HttpClientErrorException e) {
				logger.error(e.getMessage());
				return new Response("Default");
	
			} catch (JsonProcessingException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

		}

		return null;
	}

	public Response getThinPoolMetrics(Symmetrix symmetrix, ThinPool pool) {
		if (symmetrix != null && pool != null) {

			ThinPoolMetricRequest request = new ThinPoolMetricRequest();
			DateTime dt = new DateTime();

			List<String> metricList = new ArrayList<String>();
			metricList.add("PercentUsedCapacity");
			metricList.add("TotalPoolCapacity");
			metricList.add("UsedPoolCapacity");
			metricList.add("EnabledPoolCapacity");

			request.setSymmetrixId(symmetrix.getSymmetrixId());
			request.setPoolId(pool.getPoolId());
			request.setDataFormat("Average");
			request.setEndDate(dt.toDate().getTime());
			request.setStartDate(dt.minusMinutes(5).toDate().getTime());
			request.setMetrics(metricList);

			try {
				HttpEntity<ThinPoolMetricRequest> httpEntityRequest = new HttpEntity<ThinPoolMetricRequest>(request);
				logger.info(
						"ThinPoolMetricsRequestBody:" + objectMapper.writeValueAsString(httpEntityRequest.getBody()));

				Response retVal = restTemplate.postForObject(restUrl + thinPoolMetrics, httpEntityRequest,
						Response.class);
				logger.info("ThinPoolMetricsResponse:" + objectMapper.writeValueAsString(retVal));

				return retVal;
			} catch (HttpClientErrorException e) {
				logger.error(e.getMessage());
				return new Response("Default");
			} catch (JsonProcessingException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

		}

		return null;

	}

	public Response getSrpMetrics(Symmetrix symmetrix, Srp srp) {

		if (symmetrix != null && srp != null) {

			SrpMetricRequest request = new SrpMetricRequest();
			DateTime dt = new DateTime();

			List<String> metricList = new ArrayList<String>();
			metricList.add("TotalSRPCapacity");
			metricList.add("UsedSRPCapacity");

			request.setSymmetrixId(symmetrix.getSymmetrixId());
			request.setSrpId(srp.getSrpId());
			request.setDataFormat("Average");
			request.setEndDate(dt.toDate().getTime());
			request.setStartDate(dt.minusMinutes(5).toDate().getTime());
			request.setMetrics(metricList);
			try {
				HttpEntity<SrpMetricRequest> httpEntityRequest = new HttpEntity<SrpMetricRequest>(request);
				logger.info("SrpMetricsRequestBody:" + objectMapper.writeValueAsString(httpEntityRequest.getBody()));

				Response retVal = restTemplate.postForObject(restUrl + srpMetrics, httpEntityRequest, Response.class);
				logger.info("SrpMetricsResponse:" + objectMapper.writeValueAsString(retVal));

				return retVal;

			} catch (HttpClientErrorException e) {
				logger.error(e.getMessage());
				return new Response("Default");

			} catch (JsonProcessingException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

		}

		return null;

	}

	public SymmetrixService() {

	}

	public void createXmlFile() throws JsonProcessingException {
		List<Map<String, Object>> metricList= new ArrayList<Map<String, Object>>();
		SymmetrixMetrics metrics= new SymmetrixMetrics();

		Map<String, Object> symmetrixMetricList;
		SymmetrixMetric symmetrixMetric;
		
		List<String> symmetrixIdList = getSymetrixList();
		for (String symmetrixId : symmetrixIdList) {	
			symmetrixMetricList = new HashMap<String, Object>();
			symmetrixMetricList.put("Array-"+symmetrixId, getArrayMetric(symmetrixId));
			symmetrixMetricList.put("ThinPools-"+symmetrixId, getPoolMetricList(symmetrixId));
			symmetrixMetricList.put("SRPs-"+symmetrixId, getSrpMetricList(symmetrixId));
			metricList.add(symmetrixMetricList);
		}
		
		metrics.setSymmetrixMetricList(metricList);
		
		XmlMapper xmlMapper = new XmlMapper();

		try {
			xmlMapper.writeValue(new File(xmlFileName), metrics);
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	private Map<String, Object> getSrpMetricList(String symmetrixId) throws JsonProcessingException {
		Symmetrix symmetrix = new Symmetrix(symmetrixId);
		List<Srp> srpList = getSrpListForSymmetrix(symmetrix);
		Response response = null;

		if (srpList != null && srpList.size() > 0) {
			Map<String, Object> srpMetricList = new HashMap<String, Object>();

			for (Srp srp : srpList) {

				response = getSrpMetrics(symmetrix, srp);
				if (response != null && response.getResultList() != null
						&& response.getResultList().getResult() != null) {
					Result result = response.getResultList().getResult().get(0);
					if (result != null) {
						SrpMetric srpMetric = new SrpMetric();
						srpMetric.setTotalSrpCapacity(result.getTotalSRPCapacity());
						srpMetric.setUsedSrpCapacity(result.getUsedSRPCapacity());
						String s= srp.getSrpId().replaceAll("\\*", "_");
						srpMetricList.put("SRP_"+s,srpMetric);
					}

				}

			}
			return srpMetricList;
		}
		return null;
	}

	private Map<String, Object> getPoolMetricList(String symmetrixId) throws JsonProcessingException {

		Symmetrix symmetrix = new Symmetrix(symmetrixId);
		List<ThinPool> poolList = getPoolListForSymmetrix(symmetrix);
		Response response = null;

		if (poolList != null && poolList.size() > 0) {
			Map<String, Object> poolMetricList = new HashMap<String, Object>();

			for (ThinPool pool : poolList) {

				response = getThinPoolMetrics(symmetrix, pool);
				if (response != null && response.getResultList() != null
						&& response.getResultList().getResult() != null) {
					Result result = response.getResultList().getResult().get(0);
					if (result != null) {
						ThinPoolMetric poolMetric = new ThinPoolMetric();
						poolMetric.setEnabledPoolCapacity(result.getEnabledPoolCapacity());
						poolMetric.setPercentUsedCapacity(result.getPercentUsedCapacity());
						poolMetric.setTotalPoolCapacity(result.getTotalPoolCapacity());
						poolMetric.setUsedPoolCapacity(result.getUsedPoolCapacity());
						String s= pool.getPoolId().replaceAll("\\*", "_");
						poolMetricList.put("ThinPool_"+s,poolMetric);
					}

				}

			}
			return poolMetricList;
		}

		return null;
	}

	private ArrayMetric getArrayMetric(String symmetrixId) throws JsonProcessingException {

		Response arrayResponse = getArrayMetrics(new Symmetrix(symmetrixId));
		if (arrayResponse != null) {
			Result result = arrayResponse.getResultList().getResult().get(0);

			if (result != null) {

				ArrayMetric arrayMetric = new ArrayMetric();

				arrayMetric.setAllocatedCapacityTb(result.getAllocatedCapacityTB());
				arrayMetric.setCriticalAlertCount(result.getCriticalAlertCount());
				arrayMetric.setHardwareHealthScore(result.getHardwareHealthScore());
				arrayMetric.setOverallHealthScore(result.getOverallHealthScore());
				arrayMetric.setSoftwareHealthScore(result.getSoftwareHealthScore());
				arrayMetric.setSubscribedCapacityTb(result.getSubscribedCapacityTB());
				arrayMetric.setUsableCapacityTb(result.getUsableCapacityTB());

				return arrayMetric;
			}
		}

		return null;
	}

}
