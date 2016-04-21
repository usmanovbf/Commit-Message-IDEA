/*
 * Copyright 2014 Bulat Usmanov <usmanovbf@yandex.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.usmanovbf.commit_message_idea;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.CommitMessageI;
import com.intellij.openapi.vcs.VcsDataKeys;
import com.intellij.openapi.vcs.ui.Refreshable;
import org.jetbrains.annotations.Nullable;

/**
 * @author darekkay
 */
public class CommitMessage extends AnAction {

	public void actionPerformed(AnActionEvent e) {
		final CommitMessageI checkinPanel = getCheckinPanel(e);
		if (checkinPanel == null)
			return;

		final Project project = e.getProject();

		String commitMessage = transformCommitMessage();
		if (!commitMessage.isEmpty()) {
			checkinPanel.setCommitMessage(commitMessage);
		}

	}

	public String transformCommitMessage() {
		String commitMessage = null;


		return commitMessage;
	}

	@Nullable
	private static CommitMessageI getCheckinPanel(@Nullable AnActionEvent e) {
		if (e == null) {
			return null;
		}
		Refreshable data = Refreshable.PANEL_KEY.getData(e.getDataContext());
		if (data instanceof CommitMessageI) {
			return (CommitMessageI) data;
		}
		CommitMessageI commitMessageI = VcsDataKeys.COMMIT_MESSAGE_CONTROL.getData(e.getDataContext());
		if (commitMessageI != null) {
			return commitMessageI;
		}
		return null;
	}
}