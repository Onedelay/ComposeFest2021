/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelabs.state.todo

import com.codelabs.state.util.generateRandomTodoItem
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TodoViewModelTest {

    @Test
    fun whenRemovingItem_updatesList() {
        // before
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        // during
        viewModel.removeItem(item1)

        // MutableState<T> write 가 다른 스레드에서 이루어질 경우 결과가 늦게 반영될 수 있음.
        // 저수준 API 로 Snapshot.sendApplyNotifications() 를 호출해야함 (고수준 API 는 개발 진행중)

        // after
        assertThat(viewModel.todoItems).isEqualTo(listOf(item2))
    }

    // DB 비동기 처리 결과 테스트는 이를 기다리는 API 가 없어 현재 불가능 (1.0 버전 전에 준비되지 않음)

}
