<template>
  <div>
    <h1>員工座位管理系統</h1>

    <h2>員工列表</h2>

    <ul>
      <li v-for="emp in employees" :key="emp.empId">
        {{ emp.empId }} - {{ emp.name }}
      </li>
    </ul>

    <h2>選擇員工</h2>

    <select v-model="selectedEmpId">
      <option value="">請選擇員工</option>

      <option
          v-for="emp in employees"
          :key="emp.empId"
          :value="emp.empId"
      >
        {{ emp.empId }} - {{ emp.name }}
      </option>
    </select>

    <br><br />

    <button @click="assignSeat">
      送出座位
    </button>

    <button
        @click="clearSeat"
        style="margin-left:10px"
    >
      清除座位
    </button>

    <h2>座位圖</h2>

    <h3>1F</h3>

    <div class="seat-row">
      <div
          v-for="seat in seats.filter(s => s.floorNo === 1)"
          :key="seat.floorSeatSeq"
          :class="[
            'seat',
            getSeatClass(seat)
          ]"
          @click="selectSeat(seat)"
      >
        <div>
          {{ seat.floorNo }}樓:座位{{ seat.seatNo }}
        </div>
        <div
          v-if="getSeatEmployee(seat.floorSeatSeq)"
        >
          [員工編號:
          {{ getSeatEmployee(seat.floorSeatSeq).empId }}
          ]
        </div>
      </div>
    </div>

    <h3>2F</h3>

    <div class="seat-row">
      <div
          v-for="seat in seats.filter(s => s.floorNo === 2)"
          :key="seat.floorSeatSeq"
          :class="[
            'seat',
            getSeatClass(seat)
          ]"
          @click="selectSeat(seat)"
      >
        <div>
          {{ seat.floorNo }}樓:座位{{ seat.seatNo }}
        </div>
        <div
            v-if="getSeatEmployee(seat.floorSeatSeq)"
        >
          [員工編號:
          {{ getSeatEmployee(seat.floorSeatSeq).empId }}
          ]
        </div>
      </div>
    </div>

  <div class="legend">

  <span class="legend-item">
    <span class="legend-box seat-empty"></span>
    空位
  </span>

    <span class="legend-item">
    <span class="legend-box seat-occupied"></span>
    已佔位
  </span>

    <span class="legend-item">
    <span class="legend-box seat-selected"></span>
    請選擇
  </span>

  </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const employees = ref([])
const seats = ref([])
const selectedEmpId = ref("")
const selectedSeat = ref(null)

function getSeatEmployee(seatSeq) {
  return employees.value.find(
      emp => emp.floorSeatSeq === seatSeq
  )
}

function getSeatClass(seat) {

  const emp = getSeatEmployee(
      seat.floorSeatSeq
  )

  if (
      selectedSeat.value &&
      selectedSeat.value.floorSeatSeq ===
      seat.floorSeatSeq
  ) {
    return 'seat-selected'
  }

  if (emp) {
    return 'seat-occupied'
  }

  return 'seat-empty'
}

function selectSeat(seat) {

  const emp = getSeatEmployee(
      seat.floorSeatSeq
  )

  if (emp) {
    alert("此座位已有人")
    return
  }

  if (!selectedEmpId.value) {
    alert("請先選擇員工")
    return
  }

  selectedSeat.value = seat
}

async function assignSeat() {

  if (!selectedEmpId.value) {
    alert("請選擇員工")
    return
  }

  if (!selectedSeat.value) {
    alert("請選擇座位")
    return
  }

  await axios.put(
      'http://localhost:8080/api/seats/assign',
      {
        empId: selectedEmpId.value,
        seatSeq: selectedSeat.value.floorSeatSeq
        }
  )
  alert("座位指派成功")
  location.reload()
}

async function clearSeat() {

  if (!selectedEmpId.value) {
    alert("請先選擇員工")
    return
  }

  await axios.put(
      `http://localhost:8080/api/seats/clear/${selectedEmpId.value}`
  )

  alert("座位已清除")

  location.reload()
}

onMounted(async () => {

    const empResponse = await axios.get(
        'http://localhost:8080/api/employees'
    )

    employees.value = empResponse.data

    const seatResponse = await axios.get(
        'http://localhost:8080/api/seats'
    )
    seats.value = seatResponse.data

})

</script>

<style>
body {
  font-family: Arial, sans-serif;
  padding: 20px;
}

.seat-row {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

.seat {
  width: 140px;
  height: 100px;

  border: 1px solid #333;

  display: flex;
  flex-direction: column;

  justify-content: center;
  align-items: center;

  cursor: pointer;
}

.seat-empty {
  background-color: #d3d3d3;
}

.seat-occupied {
  background-color: #ff6b6b;
}

.seat-selected {
  background-color: #90ee90;
}

.legend {
  display: flex;
  gap: 20px;
  margin-bottom: 20px;
}

.legend-item {
  display: flex;
  align-items: center;
  gap: 5px;
}

.legend-box {
  width: 20px;
  height: 20px;
  border: 1px solid black;
}
</style>
