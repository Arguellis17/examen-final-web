// src/data/mockData.ts

export const mockStudents = [
  { id: 'S001', name: 'Alice Smith', email: 'alice@example.com', enrollmentStatus: 'ACTIVE' },
  { id: 'S002', name: 'Bob Johnson', email: 'bob@example.com', enrollmentStatus: 'INACTIVE' },
  { id: 'S003', name: 'Charlie Brown', email: 'charlie@example.com', enrollmentStatus: 'ACTIVE' },
];

export const mockTeachers = [
  { id: 'T001', name: 'Ms. Emily White', email: 'emily@example.com', department: 'Mathematics' },
  { id: 'T002', name: 'Mr. David Green', email: 'david@example.com', department: 'Science' },
];

export const mockSubjects = [
  { id: 'SUB001', name: 'Algebra I', code: 'MATH101', description: 'Introductory algebra course.' },
  { id: 'SUB002', name: 'Biology II', code: 'BIO201', description: 'Advanced biology concepts.' },
];

export const mockUsers = [
  { id: 'U001', username: 'admin', role: 'ADMIN', email: 'admin@example.com' },
  { id: 'U002', username: 'alice.s', role: 'STUDENT', email: 'alice@example.com' },
  { id: 'U003', username: 'emily.w', role: 'TEACHER', email: 'emily@example.com' },
];

export const mockGrades = [
  { id: 'G001', studentId: 'S001', subjectId: 'SUB001', score: 95, grade: 'A', date: '2023-05-15' },
  { id: 'G002', studentId: 'S002', subjectId: 'SUB001', score: 70, grade: 'C', date: '2023-05-15' },
];

export const mockEvaluations = [
  { id: 'E001', studentId: 'S001', subjectId: 'SUB001', teacherId: 'T001', comments: 'Excellent participation.', date: '2023-06-01' },
  { id: 'E002', studentId: 'S002', subjectId: 'SUB001', teacherId: 'T001', comments: 'Needs to improve homework completion.', date: '2023-06-01' },
];