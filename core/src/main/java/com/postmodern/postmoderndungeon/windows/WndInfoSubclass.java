package com.postmodern.postmoderndungeon.windows;

import com.postmodern.postmoderndungeon.actors.hero.HeroClass;
import com.postmodern.postmoderndungeon.actors.hero.HeroSubClass;
import com.postmodern.postmoderndungeon.actors.hero.Talent;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.ui.HeroIcon;
import com.postmodern.postmoderndungeon.ui.TalentButton;
import com.postmodern.postmoderndungeon.ui.TalentsPane;
import com.postmodern.postmoderndungeon.windows.WndHeroInfo;
import com.postmodern.postmoderndungeon.windows.WndTitledMessage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WndInfoSubclass extends WndTitledMessage {

	public WndInfoSubclass(HeroClass cls, HeroSubClass subCls){
		super( new HeroIcon(subCls), Messages.titleCase(subCls.title()), subCls.desc());

		ArrayList<LinkedHashMap<Talent, Integer>> talentList = new ArrayList<>();
		Talent.initClassTalents(cls, talentList);
		Talent.initSubclassTalents(subCls, talentList);

		TalentsPane.TalentTierPane talentPane = new TalentsPane.TalentTierPane(talentList.get(2), 3, TalentButton.Mode.INFO);
		talentPane.title.text( Messages.titleCase(Messages.get(WndHeroInfo.class, "talents")));
		talentPane.setRect(0, height + 5, width, talentPane.height());
		add(talentPane);
		resize(width, (int) talentPane.bottom());

	}

}
