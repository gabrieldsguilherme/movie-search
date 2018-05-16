package com.movie.search.integration.themoviedb;

public enum Genre {
	
	Action(28) {
		@Override
		public Boolean isCompatibleWithTemperature(Long temperature) {
			return temperature.compareTo(40L) > 0;
		}
	},
	Comedy(35) {
		@Override
		public Boolean isCompatibleWithTemperature(Long temperature) {
			return temperature.compareTo(36L) >= 0 && temperature.compareTo(40L) <= 0;
		}
	},
	Animation(16) {
		@Override
		public Boolean isCompatibleWithTemperature(Long temperature) {
			return temperature.compareTo(20L) >= 0 && temperature.compareTo(35L) <= 0;
		}
	},
	Mystery(9648) {
		@Override
		public Boolean isCompatibleWithTemperature(Long temperature) {
			return temperature.compareTo(0L) >= 0 && temperature.compareTo(20L) <= 0;
		}
	},
	Documentary(99) {
		@Override
		public Boolean isCompatibleWithTemperature(Long temperature) {
			return temperature.compareTo(0L) < 0;
		}
	};
	
	private int id;
	
	Genre(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public abstract Boolean isCompatibleWithTemperature(Long temperature);

}
