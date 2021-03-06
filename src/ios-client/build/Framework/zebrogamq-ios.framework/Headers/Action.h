/**
 ZebroGaMQ: Communication Middleware for Mobile Gaming
 Copyright: Copyright (C) 2009-2012
 Contact: denis.conan@telecom-sudparis.eu, michel.simatic@telecom-sudparis.eu

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 3 of the License, or any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 USA

 Developer(s): Michel SIMATIC, Van Hung LE
 */

#ifndef ACTION_H_
#define ACTION_H_

#include <vector>
#include <string>

#include "GameLogicState.h"

typedef void (*Function)(GameLogicState const&, std::vector<std::string> const&, std::string const&);
// Les parametres devraient etre l'equivalent du Java : (final GameLogicState state, final String[] header, final String body)

typedef struct {
	std::string s;
	Function f;
} String2Function;

class Action {
public:
	std::string getKind() const;
	std::vector<String2Function> getList() const;
	std::string toString() const;

protected:
	void add(std::string s, Function f);
	void setKind(std::string aKind);

private:
	std::string m_kind;
	std::vector<String2Function> m_list;
};

#endif /* ACTION_H_ */
