package com.utp.repo;

import com.utp.model.ResetToken;

public interface IResetTokenRepo extends IGenericRepo<ResetToken, Integer>{
	
	//from ResetToken rt where rt.token = :?
	ResetToken findByToken(String token);

}
