package com.cg.ipla;

	public class IPLException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		enum ExceptionType {
		       WRONG_CSV, WRONG_TYPE, INTERNAL_ISSUE, UNABLE_TO_PARSE, NO_DATA
		    }
			
			ExceptionType type;
		
			public IPLException(String message, ExceptionType type) {
				super(message);
				this.type = type;
			}

}
