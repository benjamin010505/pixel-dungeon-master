package com.postmodern.postmoderndungeon.windows;

import com.postmodern.postmoderndungeon.actors.hero.HeroClass;
import com.postmodern.postmoderndungeon.actors.hero.Talent;
import com.postmodern.postmoderndungeon.actors.hero.abilities.ArmorAbility;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.sprites.ItemSprite;
import com.postmodern.postmoderndungeon.sprites.ItemSpriteSheet;
import com.postmodern.postmoderndungeon.ui.HeroIcon;
import com.postmodern.postmoderndungeon.ui.TalentButton;
import com.postmodern.postmoderndungeon.ui.TalentsPane;
import com.watabou.noosa.Image;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WndInfoArmorAbility extends WndTitledMessage {

	public WndInfoArmorAbility(HeroClass cls, ArmorAbility ability){
		super( new HeroIcon(ability), Messages.titleCase(ability.name()), ability.desc());

		ArrayList<LinkedHashMap<Talent, Integer>> talentList = new ArrayList<>();
		Talent.initArmorTalents(ability, talentList);

		TalentsPane.TalentTierPane talentPane = new TalentsPane.TalentTierPane(talentList.get(3), 4, TalentButton.Mode.INFO);
		talentPane.title.text( Messages.titleCase(Messages.get(WndHeroInfo.class, "talents")));
		talentPane.setRect(0, height + 5, width, talentPane.height());
		add(talentPane);
		resize(width, (int) talentPane.bottom());

	}

}
