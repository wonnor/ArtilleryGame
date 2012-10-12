package com.pro.artillery.state;

public class StateMachine
{
	private static State currentState; 
	
	public static State getCurrentState()  //returns the current state
	{
		return currentState;
	}

	public static void setCurrentState(State currentState)
	{
		StateMachine.currentState = currentState;
	}
	
	public static void advanceTurn() //advances the turn
	{
		if(getCurrentState() == State.PLAYER_ONE_TURN)
		{
			setCurrentState(State.PLAYER_TWO_TURN);
		}
		else if(getCurrentState() == State.PLAYER_TWO_TURN)
		{
			setCurrentState(State.PLAYER_ONE_TURN);
		}
	}
	//Opens a menu
	public static void openMenu(State state)
	{
		if(state == State.START_MENU || state == State.MAIN_MENU ||state == State.PAUSE_MENU)
			setCurrentState(state);
		else
			return;
	}
	
	//list of states
	public enum State
	{
		START_MENU, MAIN_MENU, PAUSE_MENU,
		PLAYER_ONE_TURN, PLAYER_TWO_TURN;
	}
}
