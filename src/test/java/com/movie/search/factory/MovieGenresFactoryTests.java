package com.movie.search.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.movie.search.integration.themoviedb.Genre;

public class MovieGenresFactoryTests {
	
	@Test
	public void testActionTemperature() {
		assertFalse(Genre.Action.isCompatibleWithTemperature(39L));
		assertFalse(Genre.Action.isCompatibleWithTemperature(40L));
		assertTrue(Genre.Action.isCompatibleWithTemperature(41L));
	}
	
	@Test
	public void testComedyTemperature() {
		assertFalse(Genre.Comedy.isCompatibleWithTemperature(35L));
		assertTrue(Genre.Comedy.isCompatibleWithTemperature(36L));
		assertTrue(Genre.Comedy.isCompatibleWithTemperature(39L));
		assertTrue(Genre.Comedy.isCompatibleWithTemperature(40L));
		assertFalse(Genre.Comedy.isCompatibleWithTemperature(41L));
	}
	
	@Test
	public void testAnimationTemperature() {
		assertFalse(Genre.Animation.isCompatibleWithTemperature(19L));
		assertTrue(Genre.Animation.isCompatibleWithTemperature(20L));
		assertTrue(Genre.Animation.isCompatibleWithTemperature(34L));
		assertTrue(Genre.Animation.isCompatibleWithTemperature(35L));
		assertFalse(Genre.Animation.isCompatibleWithTemperature(36L));
	}
	
	@Test
	public void testMysteryTemperature() {
		assertFalse(Genre.Mystery.isCompatibleWithTemperature(-1L));
		assertTrue(Genre.Mystery.isCompatibleWithTemperature(0L));
		assertTrue(Genre.Mystery.isCompatibleWithTemperature(19L));
		assertFalse(Genre.Mystery.isCompatibleWithTemperature(20L));
	}
	
	@Test
	public void testDocumentaryTemperature() {
		assertTrue(Genre.Documentary.isCompatibleWithTemperature(-1L));
		assertFalse(Genre.Documentary.isCompatibleWithTemperature(0L));
		assertFalse(Genre.Documentary.isCompatibleWithTemperature(1L));
	}

}
