package com.postmodern.postmoderndungeon.actors.buffs;

import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.ui.BuffIndicator;

public class LostInventory extends Buff {

	{
		type = buffType.NEGATIVE;
	}

	@Override
	public int icon() {
		return BuffIndicator.NOINV;
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc");
	}

}
