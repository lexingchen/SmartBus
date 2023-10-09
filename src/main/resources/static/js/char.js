const ctx = document.getElementById("myChart");
const labels = [
  "一月份",
  "二月份",
  "三月份",
  "四月份",
  "五月份",
  "六月份",
  "七月份",
]; // 设置 X 轴上对应的标签
const data = {
  labels: labels,
  datasets: [
    {
      label: "总人数",
      data: [65, 59, 80, 81, 56, 55, 40],
      fill: false,
      borderColor: "rgb(75, 192, 192)",
      tension: 0.1,
    },
    {
      label: "滞留",
      data: [85, 79, 100, 101, 76, 75, 60],
      fill: false,
      borderColor: "rgb(175, 92, 92)",
      tension: 0,
      showLine: true,
    },
  ],
};
const config = {
  type: "line", // 设置图表类型
  data: data,
};
const myChart = new Chart(ctx, config);
// 柱状图

const ctx2 = document.getElementById("myChart2");

const data2 = {
  labels: labels,
  datasets: [
    {
      label: "调度预期",
      data: [65, 59, 80, 81, 56, 55, 40],
      backgroundColor: [
        // 设置每个柱形图的背景颜色
        "rgba(75, 192, 192, 0.2)",
      ],
      borderWidth: 1, // 设置线条宽度
    },
    {
      label: "运输总量",
      data: [85, 79, 100, 101, 76, 75, 60],
      backgroundColor: [
        // 设置每个柱形图的背景颜色
        "rgba(255, 99, 132, 0.2)",
      ],
      borderWidth: 1, // 设置线条宽度
    },
  ],
};
const config2 = {
  type: "bar", // 设置图表类型
  data: data2, // 设置数据集
  options: {
    scales: {
      y: {
        beginAtZero: true, // 设置 y 轴从 0 开始
      },
    },
  },
};
const myChart2 = new Chart(ctx2, config2);
