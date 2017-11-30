package cn.edu.nuc.weibo.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.weibo.dao.interfaces.PlusOrMinusMapper;
import cn.edu.nuc.weibo.dao.interfaces.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusQureyInfoMapper;
import cn.edu.nuc.weibo.entity.PlusOrMinus;
import cn.edu.nuc.weibo.entity.POJO.PlusOrMinusPOJO;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.PlusOrMinusManagement.PlusOrMinusInfo.PlusOrMinusPageVO;
import cn.edu.nuc.weibo.entity.VO.ProjectManagement.ProjectMaterialManagement.ProjectMaterialInfo.ProjectPageVO;
import cn.edu.nuc.weibo.entity.searchObj.PlusOrMinusInfoSearchObj;
import cn.edu.nuc.weibo.service.interfaces.PlusOrMinusInfoService;
@Service
public class PlusOrMinusInfoServiceImpl implements PlusOrMinusInfoService{
	
	@Autowired
	private PlusOrMinusQureyInfoMapper plusOrMinusQureyInfoMapper;
	@Autowired
	private PlusOrMinusMapper plusOrMinusMapper;

	public List<PlusOrMinusPageVO> queryByPage(PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj) {

		List<PlusOrMinusPageVO> plusOrMinusInfos = plusOrMinusQureyInfoMapper.queryByPage(plusOrMinusInfoSearchObj);
		
		return plusOrMinusInfos;
		
	}
	
	public int queryCount(PlusOrMinusInfoSearchObj plusOrMinusInfoSearchObj) {

		int count = plusOrMinusQureyInfoMapper.queryCount(plusOrMinusInfoSearchObj);
		
		return count;
		
	}
	
	public int AddPlusOrMinus(List<PlusOrMinusPOJO> list) {
		
		int count = 0;
		
		for( int i = 0; i < list.size(); i++){
			
			Date date=null;
			String  dates = list.get(i).getPlusOrMinusDate();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = formatter.parse(dates);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String str1=  list.get(i).getPlusOrMinusMoney();
			BigDecimal bd=new BigDecimal(str1);
			System.out.println(bd);
			
			PlusOrMinus pom = new PlusOrMinus();
			pom.setContractNo(list.get(i).getContractNo());
			pom.setContractPeriod(list.get(i).getContractPeriod());
			pom.setId(list.get(i).getId());
			pom.setPlusOrMinusContent(list.get(i).getPlusOrMinusContent());
			pom.setPlusOrMinusDate(date);
//			pom.setPlusOrMinusMoney(bd);
			pom.setState(list.get(i).getId());
			pom.setProjectNo(list.get(i).getProjectNo());
			pom.setState(1);
			
			 count =  plusOrMinusMapper.insertSelective(pom);
			System.out.println(count);
			
		}
		
		
			return count;
		
		
	}

}
